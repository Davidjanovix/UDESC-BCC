#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

typedef struct {
    int dia;
    int mes;
    int ano;
} Data;

typedef struct {
    int hora;
    int minuto;
} Horario;

typedef struct {
    Data data;
    Horario inicio;
    Horario fim;
    char descricao[100];
    char local[100];
} Evento;

typedef enum {
    SUCCESS,
    ERROR_ALLOCATION,
    ERROR_INVALID_INPUT,
    ERROR_EVENT_NOT_FOUND,
    ERROR_NO_EVENT_REGISTERED,
    ERROR_EVENT_CONFLICT,
    ERROR_FILE_NOT_FOUND,
    ERROR_FILE_WRITE,
    ERROR_FILE_READ
} Exception;

int diasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

void toUpper(char *str) {
    for (int i = 0; str[i] != '\0'; i++) {
        str[i] = toupper((unsigned char)str[i]);
    }
}

Exception lerInteiro(int *saida,int valorMinimo, int valorMaximo) {
    char buffer[100];

    if (!fgets(buffer, sizeof(buffer), stdin)) {
        return ERROR_INVALID_INPUT; // erro ao ler
    }

    // Remove o \n
    buffer[strcspn(buffer, "\n")] = '\0';

    // Tenta converter para número
    char extra; //Variável para capturar caracteres extras
    if (sscanf(buffer, "%d %c", saida, &extra) != 1) { //Verifica se leu apenas um inteiro
        return ERROR_INVALID_INPUT; // Entrada inválida
    }
    if (*saida < valorMinimo || *saida > valorMaximo) {
        return ERROR_INVALID_INPUT; // Valor fora do intervalo
    }
    return SUCCESS;
}

void tratarExcecao(Exception e) {
    switch (e) {
        case ERROR_ALLOCATION:
            printf("Erro de alocação de memória.\n");
            break;
        case ERROR_INVALID_INPUT:
            printf("Entrada inválida.\n");
            break;
        case ERROR_EVENT_NOT_FOUND:
            printf("Evento não encontrado.\n");
            break;
        case ERROR_NO_EVENT_REGISTERED:
            printf("Nenhum evento cadastrado.\n");
            break;
        case ERROR_EVENT_CONFLICT:
            printf("Conflito de horário para o evento.\n");
            break;
        case ERROR_FILE_NOT_FOUND:
            printf("Arquivo não encontrado.\n");
            break;
        case ERROR_FILE_WRITE:
            printf("Erro ao escrever no arquivo.\n");
            break;
        case ERROR_FILE_READ:
            printf("Erro ao ler o arquivo.\n");
            break;
    }
}

int menu() {
    int opt;
    printf("\nMenu de Eventos\n");
    printf("1 - Cadastrar evento\n");
    printf("2 - Mostrar eventos\n");
    printf("3 - Buscar por data\n");
    printf("4 - Buscar por descrição\n");
    printf("5 - Remover evento\n");
    printf("6 - Sair do programa\n");
    printf("Escolha uma opção: ");
    if(lerInteiro(&opt, 1, 6) == ERROR_INVALID_INPUT) {
        printf("Opção inválida. Tente novamente.\n");
        return menu(); // Chama o menu novamente se a entrada for inválida
    }
    return opt;
}

Exception cadastrarEvento(Evento **eventos, int *numEventos) {
    Evento novoEvento;
    printf("Digite o ano: ");
    if (lerInteiro(&novoEvento.data.ano, 2025, 2100) == ERROR_INVALID_INPUT) {
        return ERROR_INVALID_INPUT;
    }
    printf("Digite o mês: ");
    if (lerInteiro(&novoEvento.data.mes, 1, 12) == ERROR_INVALID_INPUT) {
        return ERROR_INVALID_INPUT;
    }
    printf("Digite o dia: ");
    if (lerInteiro(&novoEvento.data.dia, 1, diasMes[novoEvento.data.mes - 1]) == ERROR_INVALID_INPUT) {
        return ERROR_INVALID_INPUT;
    }
    if (novoEvento.data.dia <= 0 || novoEvento.data.mes <= 0 || novoEvento.data.ano <= 0) {
        return ERROR_INVALID_INPUT;
    }
    printf("Digite a hora de início: ");
    lerInteiro(&novoEvento.inicio.hora, 0, 23);
    printf("Digite o minuto de início: ");
    lerInteiro(&novoEvento.inicio.minuto, 0, 59);
    printf("Digite a hora de fim: ");
    lerInteiro(&novoEvento.fim.hora, 0, 23);
    printf("Digite o minuto de fim: ");
    lerInteiro(&novoEvento.fim.minuto, 0, 59);
    if (novoEvento.fim.hora < novoEvento.inicio.hora ||
        (novoEvento.fim.hora == novoEvento.inicio.hora && novoEvento.fim.minuto < novoEvento.inicio.minuto)) {
        printf("Erro: O horário de fim deve ser maior ou igual ao horário de início.\n");
        return ERROR_INVALID_INPUT; // Fim antes do início
    }
    printf("Digite a descrição do evento: ");
    fgets(novoEvento.descricao, sizeof(novoEvento.descricao), stdin);
    novoEvento.descricao[strcspn(novoEvento.descricao, "\n")] = '\0'; // Remove o \n
    printf("Digite o local do evento: ");
    fgets(novoEvento.local, sizeof(novoEvento.local), stdin);
    novoEvento.local[strcspn(novoEvento.local, "\n")] = '\0'; // Remove o \n
    int i = 0;
    while (i < *numEventos) {
        Evento atual = (*eventos)[i];

        if (atual.data.ano > novoEvento.data.ano) break;
        if (atual.data.ano == novoEvento.data.ano && atual.data.mes > novoEvento.data.mes) break;
        if (atual.data.ano == novoEvento.data.ano && atual.data.mes == novoEvento.data.mes &&
            atual.data.dia > novoEvento.data.dia) break;
        if (atual.data.ano == novoEvento.data.ano && atual.data.mes == novoEvento.data.mes &&
            atual.data.dia == novoEvento.data.dia &&
            atual.inicio.hora > novoEvento.inicio.hora) break;
        if (atual.data.ano == novoEvento.data.ano && atual.data.mes == novoEvento.data.mes &&
            atual.data.dia == novoEvento.data.dia &&
            atual.inicio.hora == novoEvento.inicio.hora &&
            atual.inicio.minuto > novoEvento.inicio.minuto) break;

        i++;
    }
    if (*numEventos > 0) {
        if(i > 0) { // Se não for o primeiro evento
            // Verifica se há conflito de horário com o evento anterior
            Evento *eventoAtual = &(*eventos)[i];
            if (eventoAtual->data.dia == novoEvento.data.dia) {
                if (eventoAtual->fim.hora >= novoEvento.inicio.hora) {
                    if (eventoAtual->fim.hora > novoEvento.inicio.hora) {
                        return ERROR_EVENT_CONFLICT;
                    } else {
                        if (eventoAtual->fim.minuto > novoEvento.inicio.minuto)
                            return ERROR_EVENT_CONFLICT;
                    }
                }
            }
        } else { // Se for o primeiro evento
            // Verifica se há conflito de horário com o próximo evento
            Evento *eventoAtual = &(*eventos)[0];
            if (eventoAtual->data.dia == novoEvento.data.dia) {
                if (novoEvento.fim.hora >= eventoAtual->inicio.hora) {
                    if (novoEvento.fim.hora > eventoAtual->inicio.hora) {
                        return ERROR_EVENT_CONFLICT;
                    } else {
                        if (novoEvento.fim.minuto > eventoAtual->inicio.minuto)
                            return ERROR_EVENT_CONFLICT;
                    }
                }
            }
        }
    }

    Evento *temp = realloc(*eventos, (*numEventos + 1) * sizeof(Evento));
    if (!temp) {
        return ERROR_ALLOCATION;
    }
    *eventos = temp;
    for(int j = *numEventos; j > i; j--) {
        (*eventos)[j] = (*eventos)[j - 1];
    }
    (*eventos)[i] = novoEvento;
    (*numEventos)++;
    return SUCCESS;
}

Exception mostrarEventos(Evento *eventos, int numEventos) {
    if (numEventos == 0) {
        return ERROR_NO_EVENT_REGISTERED;
    }
    for (int i = 0; i < numEventos; i++) {
        printf("\n");
        printf("Evento %d:\n", i + 1);
        printf("Data: %02d/%02d/%04d\n", eventos[i].data.dia, eventos[i].data.mes, eventos[i].data.ano);
        printf("Início: %02d:%02d\n", eventos[i].inicio.hora, eventos[i].inicio.minuto);
        printf("Fim: %02d:%02d\n", eventos[i].fim.hora, eventos[i].fim.minuto);
        printf("Descrição: %s\n", eventos[i].descricao);
        printf("Local: %s\n", eventos[i].local);
    }
    return SUCCESS;
}

Exception buscarPorData(Evento *eventos, int numEventos) {
    if (numEventos == 0) {
        return ERROR_NO_EVENT_REGISTERED; // Nenhum evento cadastrado
    }
    Data data;
    printf("Digite o ano: ");
    if (lerInteiro(&data.ano, 2025, 2100) == ERROR_INVALID_INPUT)
        return ERROR_INVALID_INPUT;
    printf("Digite o mês: ");
    if (lerInteiro(&data.mes, 1, 12) == ERROR_INVALID_INPUT)
        return ERROR_INVALID_INPUT;
    printf("Digite o dia: ");
    if (lerInteiro(&data.dia, 1, diasMes[data.mes - 1]) == ERROR_INVALID_INPUT)
        return ERROR_INVALID_INPUT;

    int encontrado = 0; // Booleano para verificar se encontrou algum evento
    for (int i = 0; i < numEventos; i++) {
        if (eventos[i].data.dia == data.dia && eventos[i].data.mes == data.mes && eventos[i].data.ano == data.ano) {
            printf("\n");
            printf("Evento encontrado:\n");
            printf("Data: %02d/%02d/%04d\n", eventos[i].data.dia, eventos[i].data.mes, eventos[i].data.ano);
            printf("Início: %02d:%02d\n", eventos[i].inicio.hora, eventos[i].inicio.minuto);
            printf("Fim: %02d:%02d\n", eventos[i].fim.hora, eventos[i].fim.minuto);
            printf("Descrição: %s\n", eventos[i].descricao);
            printf("Local: %s\n", eventos[i].local);
            encontrado = 1; // Evento encontrado
        }
    }
    return encontrado ? SUCCESS : ERROR_EVENT_NOT_FOUND;
}

Exception buscarPorDescricao(Evento *eventos, int numEventos) {
    if (numEventos == 0) {
        return ERROR_NO_EVENT_REGISTERED; // Nenhum evento cadastrado
    }
    char descricao[100];
    printf("Digite parte da descrição do evento: ");
    getchar(); // Limpa o buffer
    fgets(descricao, sizeof(descricao), stdin);
    descricao[strcspn(descricao, "\n")] = '\0'; // Remove o \n
    toUpper(descricao);
    int encontrado = 0; // Booleano para verificar se encontrou algum evento
    for (int i = 0; i < numEventos; i++) {
        char descricaoEvento[100];
        strcpy(descricaoEvento, eventos[i].descricao);
        toUpper(descricaoEvento); // Converte a descrição do evento para maiúsculas
        if (strstr(descricaoEvento, descricao) != NULL) {
            printf("\n");
            printf("Evento encontrado:\n");
            printf("Data: %02d/%02d/%04d\n", eventos[i].data.dia, eventos[i].data.mes, eventos[i].data.ano);
            printf("Início: %02d:%02d\n", eventos[i].inicio.hora, eventos[i].inicio.minuto);
            printf("Fim: %02d:%02d\n", eventos[i].fim.hora, eventos[i].fim.minuto);
            printf("Descrição: %s\n", eventos[i].descricao);
            printf("Local: %s\n", eventos[i].local);
            encontrado = 1; // Evento encontrado
        }
    }
    return encontrado ? SUCCESS : ERROR_EVENT_NOT_FOUND;
}

Exception removerEvento(Evento **eventos, int *numEventos) {
    if (*numEventos == 0) {
        return ERROR_NO_EVENT_REGISTERED; // Nenhum evento cadastrado
    }
    // Solicita os dados do evento a ser removido
    Data data;
    printf("Digite o ano do evento a ser removido: ");
    if (lerInteiro(&data.ano, 2025, 2100) == ERROR_INVALID_INPUT)
        return ERROR_INVALID_INPUT;
    printf("Digite o mês do evento a ser removido: ");
    if (lerInteiro(&data.mes, 1, 12) == ERROR_INVALID_INPUT)
        return ERROR_INVALID_INPUT;
    printf("Digite o dia do evento a ser removido: ");
    if (lerInteiro(&data.dia, 1, diasMes[data.mes - 1]) == ERROR_INVALID_INPUT)
        return ERROR_INVALID_INPUT;
    Horario inicio;
    printf("Digite a hora de início do evento a ser removido: ");
    if (lerInteiro(&inicio.hora, 0, 23) == ERROR_INVALID_INPUT)
        return ERROR_INVALID_INPUT;
    printf("Digite o minuto de início do evento a ser removido: ");
    if (lerInteiro(&inicio.minuto, 0, 59) == ERROR_INVALID_INPUT)
        return ERROR_INVALID_INPUT;
    int i;
    for (i = 0; i < *numEventos; i++) {
    Evento *e = &(*eventos)[i];
    if (e->data.dia == data.dia &&
        e->data.mes == data.mes &&
        e->data.ano == data.ano &&
        e->inicio.hora == inicio.hora &&
        e->inicio.minuto == inicio.minuto) {
        break; // Evento encontrado
    }
}
    if (i == *numEventos) {
        return ERROR_EVENT_NOT_FOUND; // Evento não encontrado
    }

    // Remove o evento encontrado
    for (int j = i; j < *numEventos - 1; j++) {
        (*eventos)[j] = (*eventos)[j + 1];
    }
    *numEventos -= 1;
    *eventos = realloc(*eventos, (*numEventos) * sizeof(Evento));
    return SUCCESS;
}

Exception salvarEventos(Evento *eventos, int numEventos, const char *nomeArquivo) {
    FILE *arquivo = fopen(nomeArquivo, "w");
    if (!arquivo) {
        return ERROR_FILE_WRITE;
    }

    // Salva o número de eventos no início do arquivo
    fprintf(arquivo, "%d\n", numEventos);

    for (int i = 0; i < numEventos; i++) {
        // Usa buffers temporários para não modificar os dados originais
        char copiaDescricao[100];
        char copiaLocal[100];
        strncpy(copiaDescricao, eventos[i].descricao, sizeof(copiaDescricao));
        copiaDescricao[sizeof(copiaDescricao) - 1] = '\0'; // Garante que a string esteja terminada
        strncpy(copiaLocal, eventos[i].local, sizeof(copiaLocal));
        copiaLocal[sizeof(copiaLocal) - 1] = '\0';

        fprintf(arquivo, "%02d/%02d/%04d %02d:%02d %02d:%02d|%s|%s\n",
                eventos[i].data.dia, eventos[i].data.mes, eventos[i].data.ano,
                eventos[i].inicio.hora, eventos[i].inicio.minuto,
                eventos[i].fim.hora, eventos[i].fim.minuto,
                copiaDescricao, copiaLocal);
    }

    fclose(arquivo);
    return SUCCESS;
}

Exception carregarEventos(Evento **eventos, int *numEventos, const char *nomeArquivo) {
    FILE *arquivo = fopen(nomeArquivo, "r");
    if (!arquivo) {
        return ERROR_FILE_NOT_FOUND; // Erro ao abrir o arquivo
    }

    if (fscanf(arquivo, "%d\n", numEventos) != 1) {
        fclose(arquivo);
        return ERROR_FILE_READ;
    }

    if (*numEventos > 0) {
        *eventos = malloc(*numEventos * sizeof(Evento));
        if (!*eventos) {
            fclose(arquivo);
            return ERROR_ALLOCATION; // Erro de alocação
        }
        for (int i = 0; i < *numEventos; i++) {
            int dia, mes, ano, horaInicio, minutoInicio, horaFim, minutoFim;
            char descricao[100], local[100];
            if (fscanf(arquivo, "%d/%d/%d %d:%d %d:%d|%99[^|]|%99[^\n]\n",
                       &dia, &mes, &ano,
                       &horaInicio, &minutoInicio, &horaFim, &minutoFim,
                       descricao, local) != 9) {
                free(*eventos);
                fclose(arquivo);
                return ERROR_FILE_READ;
            }
            (*eventos)[i].data.dia = dia;
            (*eventos)[i].data.mes = mes;
            (*eventos)[i].data.ano = ano;
            (*eventos)[i].inicio.hora = horaInicio;
            (*eventos)[i].inicio.minuto = minutoInicio;
            (*eventos)[i].fim.hora = horaFim;
            (*eventos)[i].fim.minuto = minutoFim;
            strncpy((*eventos)[i].descricao, descricao, sizeof((*eventos)[i].descricao));
            (*eventos)[i].descricao[sizeof((*eventos)[i].descricao) - 1] = '\0';
            strncpy((*eventos)[i].local, local, sizeof((*eventos)[i].local));
            (*eventos)[i].local[sizeof((*eventos)[i].local) - 1] = '\0';
            (*eventos)[i].descricao[strcspn((*eventos)[i].descricao, "\n")] = '\0'; // Remove o \n
            (*eventos)[i].local[strcspn((*eventos)[i].local, "\n")] = '\0'; // Remove o \n
        }
    } else {
        *eventos = NULL;
    }

    fclose(arquivo);
    return SUCCESS;
}


int main() {
    Evento *eventos = NULL;
    int numEventos = 0;
    Exception e;

    e = carregarEventos(&eventos, &numEventos, "eventos.txt"); // Tenta carregar eventos do arquivo
    if (e != SUCCESS) {
        tratarExcecao(e);
        eventos = NULL;
        numEventos = 0;
    } else {
        printf("Eventos carregados com sucesso!\n");
    }

    while (1) {
        int opt = menu();
        switch (opt) {
            case 1:
                e = cadastrarEvento(&eventos, &numEventos);
                if (e == SUCCESS)
                    printf("Evento cadastrado com sucesso!\n");
                else
                    tratarExcecao(e);
                break;
            case 2:
                e = mostrarEventos(eventos, numEventos);
                if (e != SUCCESS) {
                    tratarExcecao(e);
                }
                break;
            case 3:
                e = buscarPorData(eventos, numEventos);
                if (e != SUCCESS) {
                    tratarExcecao(e);
                }
                break;
            case 4:
                e = buscarPorDescricao(eventos, numEventos);
                if (e != SUCCESS) {
                    tratarExcecao(e);
                }
                break;
            case 5:
                e = removerEvento(&eventos, &numEventos);
                if (e == SUCCESS) {
                    printf("Evento removido com sucesso!\n");
                } else {
                    tratarExcecao(e);
                }
                break;
            case 6:
                e = salvarEventos(eventos, numEventos, "eventos.txt");
                if (e != SUCCESS) {
                    tratarExcecao(e);
                } else {
                    printf("Eventos salvos com sucesso!\n");
                }
                free(eventos); // Libera a memória alocada para os eventos
                printf("Saindo do programa...\n");
                return 0;
        }
    }
}