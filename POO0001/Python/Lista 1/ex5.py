class Funcionario:
    def __init__(self, nome: str, cargo: str, matricula: str) -> None:
        self.__nome = nome
        self.__cargo = cargo
        self.__matricula = matricula

    def __str__(self) -> str:
        return 'Funcionário: {}, Cargo: {}, Matrícula: {}'.format(self.__nome, self.__cargo, self.__matricula)

class Emprestimo:
    def __init__(self, livro: str, usuario: str, data: str) -> None:
        self.__livro = livro
        self.__usuario = usuario
        self.__data = data

    def __str__(self) -> str:
        return 'Livro: {}, Usuário: {}, Data: {}'.format(self.__livro, self.__usuario, self.__data)

f1 = Funcionario("Maria Eduarda", "Bibliotecária", "001")
f2 = Funcionario("David Janowsky", "Atendente", "002")

e1 = Emprestimo("Dom Casmurro", "Maria Souza", "2025-03-25")
e2 = Emprestimo("O Pequeno Príncipe", "João Pedro", "2025-04-06")

print(f1)
print(f2)
print(e1)
print(e2)
