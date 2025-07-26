import axios from 'axios';
import readline from 'readline-sync';

const BASE_URL = 'http://localhost:8080/api';

async function menuPrincipal() {
  while (true) {
    console.log('\n=== Locadora de Aparelhos ===');
    console.log('1 - Gerenciar Clientes');
    console.log('2 - Listar Aparelhos');
    console.log('3 - Registrar Locação');
    console.log('4 - Listar Locações');
    console.log('0 - Sair');

    const op = readline.question('Opção: ');

    switch (op) {
      case '1': await menuClientes(); break;
      case '2': await listarAparelhos(); break;
      case '3': await registrarLocacao(); break;
      case '4': await listarLocacoes(); break;
      case '0': return;
      default: console.log('Opção inválida!');
    }
  }
}

async function menuClientes() {
  while (true) {
    console.log('\n--- Clientes ---');
    console.log('1 - Listar');
    console.log('2 - Adicionar');
    console.log('0 - Voltar');
    const op = readline.question('Opção: ');

    switch (op) {
      case '1': await listarClientes(); break;
      case '2': await adicionarCliente(); break;
      case '0': return;
      default: console.log('Opção inválida!');
    }
  }
}

async function listarClientes() {
  try {
    const res = await axios.get(`${BASE_URL}/clientes`);
    const clientes = res.data;
    if (clientes.length === 0) {
      console.log("Nenhum cliente cadastrado.");
    } else {
      clientes.forEach(c => {
        console.log(`- ${c.nome} | CPF: ${c.cpf} | Tel: ${c.telefone}`);
      });
    }
  } catch (e) {
    console.error("Erro:", e.message);
  }
}

async function adicionarCliente() {
  const nome = readline.question('Nome: ');
  const cpf = readline.question('CPF: ');
  const telefone = readline.question('Telefone: ');

  try {
    const res = await axios.post(`${BASE_URL}/clientes`, { nome, cpf, telefone });
    console.log(res.data);
  } catch (e) {
    console.error("Erro:", e.response?.data || e.message);
  }
}

async function listarAparelhos() {
  try {
    const res = await axios.get(`${BASE_URL}/aparelhos`);
    const aparelhos = res.data;

    if (aparelhos.length === 0) {
      console.log("Nenhum aparelho disponível.");
      return;
    }

    for (const a of aparelhos) {
      console.log(`- ${a.nome} | Preço: R$${a.preco} | Qtd: ${a.qtd}`);
      switch (a.tipo) {
        case 'mesa': console.log(`  Lugares: ${a.lugares}`); break;
        case 'palco': console.log(`  Área: ${a.area}m²`); break;
        case 'talher': console.log(`  Tipo: ${a.categoria || a.tipo}`); break;
        case 'gerador': console.log(`  Potência: ${a.potencia}W`); break;
      }
    }
  } catch (e) {
    console.error("Erro:", e.message);
  }
}

async function registrarLocacao() {
  try {
    const cpf = readline.question("CPF do cliente: ");
    const clientes = (await axios.get(`${BASE_URL}/clientes`)).data;
    const cliente = clientes.find(c => c.cpf === cpf);

    if (!cliente) {
      console.log("Cliente não encontrado.");
      return;
    }

    const aparelhos = (await axios.get(`${BASE_URL}/aparelhos`)).data;
    aparelhos.forEach(a => console.log(`- ${a.nome} (${a.qtd} disponíveis)`));

    const nome = readline.question("Nome do aparelho: ");
    const qtd = parseInt(readline.question("Quantidade: "), 10);

    const aparelho = aparelhos.find(a => a.nome.toLowerCase() === nome.toLowerCase());

    if (!aparelho) {
      console.log("Aparelho não encontrado.");
      return;
    }

    const req = { cliente, aparelho, quantidade: qtd };
    const res = await axios.post(`${BASE_URL}/locacoes`, req);
    console.log(res.data);

  } catch (e) {
    console.error("Erro:", e.message);
  }
}

async function listarLocacoes() {
  try {
    const res = await axios.get(`${BASE_URL}/locacoes`);
    const locacoes = res.data;
    if (locacoes.length === 0) {
      console.log("Nenhuma locação registrada.");
    } else {
      locacoes.forEach(l => {
        console.log(`- ${l.cliente.nome} alugou ${l.quantidade}x ${l.aparelho.nome}`);
      });
    }
  } catch (e) {
    console.error("Erro:", e.message);
  }
}

menuPrincipal();
