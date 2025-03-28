## Description
A service to handle a comunication request.

## Stack
- Language: Java
- Jvm Target: 17

## How to
### Test
`gradle test`
### Run
`gradle run`

## Environment Variables

| USER                                     | EXAMPLE              | DESCRIPTION                                |
|------------------------------------------|----------------------|--------------------------------------------|
| HTTP_PORT                                | 8080(default)        | enter http port to application             |
| DATABASE_HOST                            | localhost            | database host to connection                |
| DATABASE_PORT                            | 5432                 | database port to connection                |
| DATABASE_USR                             | postgres             | user to connect on database                |
| DATABASE_PWD                             | postgres             | password to connect on database            |
| DATABASE_SCHEMA                          | comunication_service | table schemas to persist comunication data |
