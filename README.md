# Dep-bd-aplication
O projeto se baseia em mostrar como um Banco de dados fica dependendo demais de uma aplicação para inserir dados.


# Apresentação da problemática

Estava estudando mais um pouco sobre java e banco de dados, quando me veio algumas curiosidades...

* O que acontece quando eu tento fazer um mapeamento de uma classe cujo atributo que ela possua seja abstrato?
* Será que consumo menos memória? Se consumir menos memória no banco, qual será o custo?

# Lado Positivo

Na nossa classe Teste temos um atributo abstrato num (do tipo Number), logo, na nossa aplicação não é preciso dizer o tipo do valor que será passado.
O atributo num, pode ser instânciado como inteiro, real etc. Esta flexibilidade irá gerar um menos consumo de dados no banco, pois o tamanho desse dado pode variar de acordo com o valor passado, podemos ver isso na classe MainApplication.java

![image](https://user-images.githubusercontent.com/76585138/129445976-9a608d4d-e4cd-4c32-a0e6-2d5538c07cba.png)

* OBS1: Number pode receber qualquer valor númerico, seja esse double, integer, float etc.


# Lado Negativo

A classe Teste possui um grande problema de depêndencia de aplicação, pois o Banco não está livre para fazer manipulação de dados de forma independente.
O problema é gerado pela criação de atributo abstrato, visto que Number é uma classe de declaração e não de instânciação.

![image](https://user-images.githubusercontent.com/76585138/129444822-485e1769-9162-4e7d-9a9e-ebe1dbd50422.png)

* O DDL da nossa tabela ficou assim:

![image](https://user-images.githubusercontent.com/76585138/129445093-94da124c-7c49-474e-a73f-62e929c3b43e.png)

Podemos ver que o nosso atributo abstrato(Java) se tornou um binary(SQL), isto porque o dado irá ser armazenado como endereço de memória, justamente pelo BD não identificar o tipo concreto do dado.

Agora... vejamos o nosso problema de depêndencia de inserção de dados:

![image](https://user-images.githubusercontent.com/76585138/129445278-2eadffe8-5412-4c5e-ada9-50e648880f21.png)

![image](https://user-images.githubusercontent.com/76585138/129445303-74586355-ae1b-452b-b798-519af36687d1.png)

Conforme podemos ver na segunda imagem, o erro ocorre por tentar inserir um dado valor númerico de forma concreta.
Para solucionar este erro teríamos que inserir um endereço de memória para que um valor númerico pudesse ser armazenado.
Desta forma podemos ver a dependência do banco para com a aplicação, pois somente a aplicação NESSE CASO pode inserir no BD o endereço de memória do dado implementado.

# Conclusão

Devemos na maioria dos casos declarar um atributo de forma concreta, para não termos uma dependência mútua para a inserção de dados entre BD e Aplicação.
Para esse caso, se partisse da ideia de consumir menos memória, seria uma boa. No entanto, teríamos que arcar com a dependência de um para que o outro funcione.

* OBS2: O código do projeto não conta com as melhores práticas, foi elaborado para uma forma mais didática.
