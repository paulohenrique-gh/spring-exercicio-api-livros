# Exercício API Livros

## Endpoints

Listar livros: 
`GET /books`

Parâmetro opcional para listar livros por gênero: genre

Exemplo:
`GET /books?genre=fantasy`

---

Livro por ID:
`GET /books/{id}`

---

Salvar livro:
`POST /books`

--- 

Alterar dados de um livro:
`PUT /books/{id}`

---

Excluir livro:
`DELETE /books/{id}`