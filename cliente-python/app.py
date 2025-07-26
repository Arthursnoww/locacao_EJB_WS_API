import requests

BASE_URL = "http://localhost:8080/api"

def menu_principal():
    while True:
        print("\n=== Locadora de Aparelhos ===")
        print("1 - Gerenciar Clientes")
        print("2 - Gerenciar Aparelhos")
        print("3 - Registrar Locação")
        print("4 - Listar Locações")
        print("0 - Sair")
        op = input("Opção: ")

        if op == "1":
            menu_clientes()
        elif op == "2":
            menu_aparelhos()
        elif op == "3":
            registrar_locacao()
        elif op == "4":
            listar_locacoes()
        elif op == "0":
            break
        else:
            print("Opção inválida!")

def menu_clientes():
    while True:
        print("\n--- Clientes ---")
        print("1 - Listar")
        print("2 - Adicionar")
        print("0 - Voltar")
        op = input("Opção: ")
        if op == "1":
            listar_clientes()
        elif op == "2":
            adicionar_cliente()
        elif op == "0":
            break
        else:
            print("Opção inválida.")

def listar_clientes():
    try:
        r = requests.get(f"{BASE_URL}/clientes")
        clientes = r.json()
        if not clientes:
            print("Nenhum cliente cadastrado.")
            return
        for c in clientes:
            print(f"- {c['nome']} | CPF: {c['cpf']} | Tel: {c['telefone']}")
    except Exception as e:
        print("Erro:", e)

def adicionar_cliente():
    nome = input("Nome: ")
    cpf = input("CPF: ")
    telefone = input("Telefone: ")
    cliente = {"nome": nome, "cpf": cpf, "telefone": telefone}
    try:
        r = requests.post(f"{BASE_URL}/clientes", json=cliente)
        print("Cliente adicionado!" if r.status_code == 200 else r.text)
    except Exception as e:
        print("Erro:", e)

def menu_aparelhos():
    while True:
        print("\n--- Aparelhos ---")
        print("1 - Listar")
        print("0 - Voltar")
        op = input("Opção: ")
        if op == "1":
            listar_aparelhos()
        elif op == "0":
            break
        else:
            print("Opção inválida.")

def listar_aparelhos():
    try:
        r = requests.get(f"{BASE_URL}/aparelhos")
        aparelhos = r.json()
        if not aparelhos:
            print("Nenhum aparelho disponível.")
            return

        for a in aparelhos:
            print(f"- {a['nome']} | Preço: R${a['preco']} | Qtd: {a['qtd']}")
            match a["tipo"]:
                case "gerador":
                    print(f"  Potência: {a['potencia']}W")
                case "mesa":
                    print(f"  Lugares: {a['lugares']}")
                case "palco":
                    print(f"  Área: {a['area']}m²")
                case "talher":
                    print(f"  Tipo de talher: {a['categoria']}")

    except Exception as e:
        print("Erro:", e)

def adicionar_aparelho():
    nome = input("Nome: ")
    preco = float(input("Preço: "))
    qtd = int(input("Quantidade: "))
    aparelho = {"nome": nome, "preco": preco, "qtd": qtd}
    try:
        r = requests.post(f"{BASE_URL}/aparelhos", json=aparelho)
        print("Aparelho adicionado!" if r.status_code == 200 else r.text)
    except Exception as e:
        print("Erro:", e)

def registrar_locacao():
    try:
        print("\n--- Registrar Locação ---")
        cpf = input("CPF do cliente: ")
        cliente_resp = requests.get(f"{BASE_URL}/clientes")
        cliente = next((c for c in cliente_resp.json() if c["cpf"] == cpf), None)

        if not cliente:
            print("Cliente não encontrado.")
            return

        listar_aparelhos()
        nome_aparelho = input("Nome do aparelho: ")
        qtd = int(input("Quantidade: "))

        aparelho_resp = requests.get(f"{BASE_URL}/aparelhos")
        aparelho = next((a for a in aparelho_resp.json() if a["nome"].lower() == nome_aparelho.lower()), None)

        if not aparelho:
            print("Aparelho não encontrado.")
            return

        requisicao = {
            "cliente": cliente,
            "aparelho": aparelho,
            "quantidade": qtd
        }

        r = requests.post(f"{BASE_URL}/locacoes", json=requisicao)
        print(r.text)
    except Exception as e:
        print("Erro:", e)

def listar_locacoes():
    try:
        r = requests.get(f"{BASE_URL}/locacoes")
        json_data = r.json()
        if not json_data:
            print("Nenhuma locação encontrada")
        for l in json_data:
            print(f"- {l['cliente']['nome']} alugou {l['quantidade']}x {l['aparelho']['nome']}")
    except Exception as e:
        print("Erro:", e)

if __name__ == "__main__":
    menu_principal()
