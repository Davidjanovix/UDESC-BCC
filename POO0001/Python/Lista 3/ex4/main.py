from aluno import Aluno
from professor import Professor

if __name__ == "__main__":

    aluno1 = Aluno("Maria", [8.0, 7.5, 9.0, 6.5, 8.5])
    aluno2 = Aluno("João", [5.0, 6.0, 6.5, 5.5, 6.0])
    aluno3 = Aluno("Larissa", [9.0, 9.5, 10.0, 8.5, 9.0])
    aluno4 = Aluno("Pedro", [4.0, 5.5, 6.0, 5.0, 6.5])
    aluno5 = Aluno("Renata", [7.0, 7.0, 7.5, 6.5, 7.0])

    professor1 = Professor("Ana", 5200.75)
    professor2 = Professor("Carlos", 4780.00)

    pessoas = [aluno1, aluno2, aluno3, aluno4, aluno5, professor1, professor2]

    for pessoa in pessoas:
        print(pessoa)
