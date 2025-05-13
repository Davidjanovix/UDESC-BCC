import json

class Filme:
    def __init__(self, titulo="", ano=0, classificacao="", nota=0.0):
        self.titulo = titulo
        self.ano = ano
        self.classificacao = classificacao
        self.nota = nota

    def carregar_de_json(self, dados_json):
        self.titulo = dados_json.get("titulo", "")
        self.ano = dados_json.get("ano", 0)
        self.classificacao = dados_json.get("classificacao", "")
        self.nota = dados_json.get("nota", 0.0)

    def __str__(self):
        return f"{self.titulo} ({self.ano}) - {self.classificacao} - Nota: {self.nota}"


def ler_filmes_do_json(caminho_arquivo):
    with open(caminho_arquivo, 'r', encoding='utf-8') as f:
        dados = json.load(f)

    filmes = []
    for item in dados:
        filme = Filme()
        filme.carregar_de_json(item)
        filmes.append(filme)

    return filmes


def listar_filmes_ordenados_por_nota(filmes):
    filmes_ordenados = sorted(filmes, key=lambda f: f.nota, reverse=True)
    for filme in filmes_ordenados:
        print(filme)


if __name__ == "__main__":
    caminho = "filmes.json"
    filmes = ler_filmes_do_json(caminho)
    listar_filmes_ordenados_por_nota(filmes)
