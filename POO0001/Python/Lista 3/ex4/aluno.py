from pessoa import Pessoa

class Aluno(Pessoa):
    def __init__(self, nome: str, notas: list[float]):
        super().__init__(nome)
        if len(notas) != 5:
            raise ValueError("O aluno deve ter exatamente 5 notas.")
        self.__notas = notas

    def calcularMedia(self) -> float:
        return sum(self.__notas) / len(self.__notas)

    def getNotas(self) -> list[float]:
        return self.__notas.copy()

    def __repr__(self) -> str:
        media = self.calcularMedia()
        status = "aprovado" if media >= 7 else "reprovado"
        return f"Aluno(nome={self.nome}, média={media:.2f}, status={status})"

