<h1 align="center"> New Bank </h1>


<h4 align="center"> 
  STATUS:  Finalizado.  
</h4>


---

[![GitHub issues](https://img.shields.io/github/issues/yurirampazo/blogPessoal?logo=GitHub)](https://github.com/yurirampazo/blogPessoal/issues)
[![GitHub license](https://img.shields.io/github/license/yurirampazo/blogPessoal?color=3&logo=Github)](https://github.com/yurirampazo/blogPessoal)
[![GitHub forks](https://img.shields.io/github/forks/yurirampazo/blogPessoal?logo=GitHub)](https://github.com/yurirampazo/blogPessoal/network)
[![GitHub stars](https://img.shields.io/github/stars/yurirampazo/blogPessoal?logo=github)](https://github.com/yurirampazo/blogPessoal/stargazers)
![GitHub last commit](https://img.shields.io/github/last-commit/yurirampazo/blogPessoal)


---

## 📄 Sobre o Projeto
<p align="center"> 
	Simulação de banco com 5 tipos diferentes de contas, para melhor atender as necessidades dos clientes. 
  As contas herdam características gerais da classe mãe Conta. 
  Tipos de Conta: 
   - Conta Poupança
   - Conta Corrente
   - Conta Especial
   - Conta Empresa
   - Conta Estudantil
</p>


---

### Features

- [x] Verificação de Saldo.
- [x] Creditar valor.
- [x] Debitar valor.
- [x] Realizar Operação Especial (Caso o usuário queira solicitar).
- [x] Operações Limitadas: 10 Movimentações por dia.

---


## 🎲 Aplicação

```bash
# Escolha um tipo de conta.
$ Poupança, Corrente, Especial, Empresa ou Estudantil

# Digitie o número da conta.
$ Pode ser qualquer número contido na capacidade de um tipo int. (Não há validação de contas nesse projeto)

# Digite um número de CPF ou CNPJ no caso da conta Empresa
$ A única validação é o comprimento da String CPF. ( Foi utilizado o tipo String para evitar conflitos com sequências 
$ que se iniciem com 0 ou que também sejam compostas por caracteres).

# Informe o Status da Conta
$ Caso ela seja inativa a aplicação é encerrada.

# Escolha o tipo de operação que deseja realizar 
$ - Verificar o saldo
$ - Creditar valor
$ - Debitar valor
$ - Operação Especial
$ - Encerrar

# Operação Especial Conta Poupança
$ Na conta poupança quando o dia for o mesmo que o dia de criação daa conta, ela recebe 
$ um acrescimo $ de juros no seu saldo ao final da aplicação de 0,05%. 
$ Se selecionar Operação especial apenas receberá um aviso de como funciona esse crédito.

# Operação Especial Conta Corrente
$ O usuário ao sair da aplicação ou encerrar as atividades por limite deve ser capaz de 
$ solicitar um talão de R$ 1000,00. No total ele possui 3 talões.

# Operação Especial Conta Especial
$ O usuário ao realizar um débito de valor superior ao seu saldo acessa um limite especial 
$ de até R$ 1000,00 inicialmente. E enquanto possuir esse limite, poderá utilizá-lo 
$ em operações de débito, mesmo que com saldo nulo.

# Operação Especial Conta Empresa
$ O usuário pode solicitar a qualquer momento, ou ao encerrar as atividades o uso de
$ um limite empresarial de R$ 10000,00. Este valor é creditado em seu saldo.

# Operação Especial Conta Estudantil
$ O usuário pode solicitar a qualquer momento, ou ao encerrar as atividades o uso de 
$ um limite estudantil de R$ 5000,00. Este valor é creditado em seu saldo.

# Limite de Operações
$ Existe um limite de movimentações diário, 10 mao todo. São consideradas movimentações 
$ apenas créditos e débitos. Operações especiais ativas, como solicitar empréstimo e talão 
$ não contabilizam as movimentações.



```

### Autor

---

<a href="https://app.rocketseat.com.br/me/yuri-mina-rampazo-09585">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/78765799?s=400&u=f8a41d23588843f2686ec6dec0c6a588843d851e&v=4" width="100px;" alt=""/>
 <br />
 <sub><b>Yuri Rampazo</b></sub>


👋🏽 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Yuri-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/yurimrampazo/)](https://www.linkedin.com/in/yurimrampazo/) 
[![Gmail Badge](https://img.shields.io/badge/-rampazo.yu@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:rampazo.yu@gmail.com)](mailto:rampazo.yu@gmail.com)
