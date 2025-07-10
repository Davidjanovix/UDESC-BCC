'''n = int(input("Digite um número inteiro: "))
if n > 0:
    tabuada = f'Tabuada do {n}:\n'
    print(tabuada.center(20, '-'))
    for i in range(1, 11):
        resultado = n * i
        string = str(n).rjust(3) + ' x ' + str(i).rjust(2) + ' = ' + str(resultado).rjust(3)
        print(string)'''

class ObjetoSobrepostoException(Exception):
    def __init__(self, mensagem):
        super().__init__(mensagem)


class Ponto2D:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __eq__(self, other):
        return isinstance(other, Ponto2D) and self.x == other.x and self.y == other.y

    def __repr__(self):
        return f"Ponto2D({self.x}, {self.y})"


class Reta:
    def __init__(self, a, b):
        self.a = a
        self.b = b

    def intercepta(self, reta):
        if self.a == reta.a:
            return False
        return True

    def estaNaReta(self, ponto):
        return ponto.y == self.a * ponto.x + self.b

    def __repr__(self):
        return f"Reta(y = {self.a}x + {self.b})"


class EspacoGeometrico:
    def __init__(self):
        self.retas = []
        self.pontos = []

    def adicionarReta(self, reta):
        for r in self.retas:
            if r.intercepta(reta):
                raise ObjetoSobrepostoException(f"A reta {reta} intercepta com {r}")
        self.retas.append(reta)

    def adicionarPonto(self, ponto):
        for r in self.retas:
            if r.estaNaReta(ponto):
                raise ObjetoSobrepostoException(f"O ponto {ponto} está sobreposto à {r}")
        self.pontos.append(ponto)


if __name__ == "__main__":
    espaco = EspacoGeometrico()

    reta_azul = Reta(2, -2)
    reta_verde = Reta(1, 1)
    reta_vermelha = Reta(1, 2)

    ponto_A = Ponto2D(3, 4)
    ponto_B = Ponto2D(2, 3)
    ponto_C = Ponto2D(4, 6)
    ponto_D = Ponto2D(3, 2)

    try:
        espaco.adicionarReta(reta_azul)
        espaco.adicionarReta(reta_verde)
    except ObjetoSobrepostoException as e:
        print("Exceção capturada ao adicionar reta:", e)

    try:
        espaco.adicionarPonto(ponto_A)
    except ObjetoSobrepostoException as e:
        print("Exceção capturada ao adicionar ponto A:", e)

    try:
        espaco.adicionarPonto(ponto_D)
        print(f"Ponto {ponto_D} adicionado com sucesso.")
    except ObjetoSobrepostoException as e:
        print("Exceção ao adicionar ponto D:", e)
