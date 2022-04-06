const { request, response } = require("express");
const express = require("express");
const { v4: uuidv4 } = require("uuid");
const app = express();
app.use(express.json());

const customers = [];

app.post("/account", (request, response) => { /* METODO CRIAR CONTA */
    const { cpf, nome } = request.body;

    const customersAlreadyExists = customers.some(
        (customer) => customer.cpf === cpf
    );

    if (customersAlreadyExists) {
        return response.status(400).json({ error: "Customer already exists" });
    }

    const id = uuidv4();
    customers.push({
        cpf,
        nome,
        id,
        statement: [],
        balance: 0
    });
    return response.status(201).json({ Status: "Sua conta foi criada" });
})

function verifyIfExistsAccount(request, response, next) { /* FUNÇÃO VERIFICADORA SE A CONTA EXISTE */
    const { cpf } = request.headers;
    const customer = customers.find(
        (customer) => customer.cpf === cpf);

    console.log(customers)

    if (!customer) {
        return response.status(400).json({ error: "Customer not found" });
    }
    request.customer = customer;
    return next();
}

app.get("/statement", verifyIfExistsAccount, (request, response) => { /* metodo get statement */
    const { customer } = request;
    return response.json(customer);
})

app.post("/deposit", verifyIfExistsAccount, (request, response) => { /* depositando dinheiro */
    const { description, amount } = request.body
    const { customer } = request

    const statementOperation = {
        description,
        amount,
        created_at: new Date(),
        type: "credit"
    }
    customer.balance = customer.balance + amount;
    customer.statement.push(statementOperation);
    return response.status(201).send();
})

app.post("/withdraw", verifyIfExistsAccount, (request, response) => { /* sacando dinheiro */
    const { quant } = request.body
    const { customer } = request

    if ((customer.balance - quant) < 0) {
        return response.status(400).json({ error: "Customer don't have balance" });
    } else {
        customer.balance = customer.balance - quant;
        const statementOperation = {
            quant,
            created_at: new Date(),
            type: "Withdraw"
        }
        customer.statement.push(statementOperation);
        return response.status(201).send();
    }
})

app.get("/statement/date", verifyIfExistsAccount, (request, response) => { /* filtrando por data */
    const { customer } = request;
    const { date } = request.query;

    const dateFormat = new Date(date + " 00:00");

    const statement = customer.statement.filter(
        (statement) =>
        statement.created_at.toDateString() === new Date(dateFormat).toDateString()
    );
    return response.status(201).json(statement)
})

app.get("/statement/cpf", verifyIfExistsAccount, (request, response) => { /* filtrando por cpf */
    const { customer } = request;
    return response.status(201).json(customer.statement)
})

/* app.delete{ 
            deletando conta existente
} */

app.delete

app.listen(3333);