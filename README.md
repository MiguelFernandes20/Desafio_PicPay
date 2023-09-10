# Desafio_PicPay
Este repositório tem como objetivo utilizar o desafio do Back-End do PICPay como uma ferramenta para aprimorar meus estudos e habilidades.

# Objetivo: PicPay Simplificado
Temos 2 tipos de usuários, os comuns e os lojistas, ambos têm carteira com dinheiro e realizam transferências entre eles. Vamos nos atentar somente ao fluxo de transferência entre dois usuários.

# Requisitos:

Para ambos os tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser exclusivos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail.

Os usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários.

Lojistas só recebem transferências, não enviam dinheiro para ninguém.

Valide se o usuário tem saldo antes da transferência.

Antes de finalizar a transferência, você deve consultar um serviço autorizado externo, use este mock para simular ( https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6 ).

A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia.

Na coleta de pagamento, o usuário ou lojista precisa receber notificação (envio de e-mail, sms) enviada por um serviço de terceiros e eventualmente este serviço pode ser indisponível/instável. Use este mock para simular o envio ( http://o4d9z.mocklab.io/notify ).

Este serviço deve ser RESTFul.


