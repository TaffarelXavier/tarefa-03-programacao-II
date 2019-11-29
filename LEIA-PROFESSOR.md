# Tarefa-03-programacao-II

> # Guia Básico do Sistema

# Passo 1)
## Importe o script sql, denominado `sge_db.sql` para o seu `Sistema Gerenciador de Banco de Dados Mysql`.

Pode inserir este comando no console do mysql:<br>
`\. CAMINHO_DO_ARQUIVO\sge_db.sql`

# Passo 2)
### Mude o DSN (*Data Source Name*) no arquivo
`etc. > src > servicos > Conexao.java:`<br>
```java
 /**
     * <p style="font:16px arial">Strings de conexões</p>
     */
    private static final String[][] DSNS = {
        { /*Índice:0*/
            "com.mysql.jdbc.Driver",
            "jdbc:mysql://localhost:3306/sge_db",
            "root",
            "chkdsk"
        },
        { /*Índice:1*/
            "org.postgresql.Driver",
            "jdbc:postgresql://localhost:5432/banco_ifto",
            "postgres",
            "chkdsk"
        }
    };
```
Mude o item do array `DSNS`, conforme a string de conexao que está no seu sistema.

# Passo 3)

### Abra o projeto java e execute o sistema.

# Passo 4)
> Clique no ícone `Cadastrar Cursos`, aparecerá uma lista
contendo os cursos, clique sobre alguma linha para poder
habilitar as opções de cursos.

----
Por enquanto, para a tabela `curso` há as opções de:

- Incluir
- Editar
- Selecionar Todos Registros
- Excluir um registro
