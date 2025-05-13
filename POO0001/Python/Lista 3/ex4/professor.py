from pessoa import Pessoa

class Professor(Pessoa):
    def __init__(self, nome: str, salario: float):
        super().__init__(nome)
        self.__salario = salario

    def getSalario(self) -> float:
        return self.__salario

    def __repr__(self) -> str:
        return f"Professor(nome={self.nome}, salário=R${self.__salario:.2f})"
