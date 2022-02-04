Documentações Swagger:

registration-service
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config 
(após registro e confirmação do cadastro via token)

authentication-service
http://localhost:8090/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/authorization-resource/getAuthorization

employee-manager-service
http://localhost:8000/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

1.	Microsserviço registration – realiza o primeiro acesso do usuário ao serviço. Para isso, gera um token de acesso de 15 minutos, que deve ser confirmado via e-mail.
POST http://localhost:8080/api/v1/registration - Registra o usuário no Sistema, gerando um token
GET http://localhost:8080/api/v1/registration/confirm?token=? – Confirmação de token via HTTP REQUEST

Para testar o envio de e-mail via MailDev:
*Instalar e executar via cmd:
$ npm install -g maildev
$ maildev

*Ou, via docker:
Após startar o serviço docker (em Windows, por meio da interface Docker Desktop):
Execute o comando:
$ docker pull maildev/maildev
$ docker run -p 1080:1080 -p 1025:1025 maildev/maildev

MailDev é uma maneira simples de testar os e-mails gerados pelo seu projeto durante o desenvolvimento com uma interface web fácil de usar que roda em sua máquina construída sobre Node.js .

2.  Microsserviço authentication – realiza a autenticação via Bearer Token de todos os demais microsserviços – tempo de expiração: 2,35h 
Para isso, deve haver um usuário previamente cadastrado e autorizado no sistema (via registration-api).
localhost:8090/login

3.	Microsserviço employee-manager – realiza o cadastro; atualização; busca; listagem completa; listagem por diferença de idade (younger/older) e de salário(lowest/highest); e deleção, de funcionários. 

https://console.twilio.com/?frameUrl=%2Fconsole%3Fx-target-region%3Dus1
