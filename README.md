# anagram
Projeto teste para vaga de desenvolvedor java

# versões usadas:
Java 23
Angular 19

# iniciar projeto:
baixar o java 23 e o angular 19
mvn clear install dentro da pasta do anagram-api
npm install dentro da pasta do anagram-web

* iniciar backend: execute no terminal dentro da pasta anagram-api
mvn spring-boot:run

* iniciar frontend: execute no terminal dentro da pasta anagram-web
ng serve --open
link: http://localhost:4200/

O projeto foi dividido entre frontend com angular e o backend com java springboot
o frontend esta incompleto e principalmente a paginação não esta funcionando completamente certo por conta de tempo mas ja consegue demonstrar o funcionamento do gerador de anagramas.

O sistema tem como objetivo gerar todos os anagramas possiveis a partir da permuta das letras da palavra que foi enviada ao sistema.
O sistema não gera palavras reais o qual Anagrama se refere, apenas todas as possibilidades de permuta possiveis.

O usuario deve informar uma palavra na tela para que o sistema envie todos os anagramas, e foi separado o resultado por paginação para facilitar a leitura
e tambem para evitar o uso excessivo da memoria o que pode causar travamento ou fazer o sistema parar de funcionar.

O sistema usa o fatorial para calcular a quantidade total de anagramas ja que o sistema não funcionaria ao buscar todos os resultados para encontrar a contagem total com palavras grandes, a memoria padrão configurada não suportaria a quantidade de dados gerados com palavras acima de 14 digitos.

Os metodos foram descritos com comentarios no AnagramService.java e app.component.ts para mais detalhes do funcionamento do sistema, apenas essa parte foram bem comentadas por se tratar da parte mais importante do teste.