# MiniHaskell

-  Criadas novas expressoes Aritméticas:
  - [X] Divisão
  - [X] Multiplicação
  - [X] Subtração 
  - Todas expressões aritméticas agora herdam da classe abstrata ExpressãoBinariaInteiro, que
    implementa as funções tipo e checar tipo, comuns a todas as expressões dessa categoria
  
- Criadas novas expressões Booleanas:
  - [X] AND
  - [X] OR
  - [X] NOT
  - [X] !=
  - [X] <
  - [X] >
  - [X] <=
  - [X] >=
  - Todas expressões(menos a not que não é binária) agora herdam da classe abstrata ExpressãoBinariaBooleana,
    que implementa as funções tipo e checar tipo, comuns a todas as expressões dessa categoria
    
- Criado o tipo Lista com as seguintes Expressoes:
  - [X] Insere
  - [X] Busca
  - [X] Tamanho
  - [X] Remoção por meio de drop (função de remoção de elementos básica do Haskell)
  - [X] Remoção por indice *Bonus para facilitar a vida do programador de mini-Haskell
  
- Criados Testes para a função aplicação
  - [X] Testes com expressões simples de multiplicação
  - [X] Testes com expressões dentro de expressões (uso de expressaoMultiplicacao dentro de expressaoIf)
  - [X] Testes com funções recursivas (como a função de calcular o fatorial de um número)

- [X] Criados Testes para o caso let x = 10 in let x = 5 in x + 5
-  Corrigir os visitors implementados, mas que estão "quebrados" na versão 03 da implementação do projeto MiniHaskell
   - [X] Concertada  a classe Adaptor 
   - [X] Concertada a classe PPVisitor 
   - Todas classes agora herdam da interface Visitor que implementa a funcão vistar, que funciona para  todos os tipos de expressoes implementadas no programa
- [X] Criado testes para testar o Adaptor
   - Criado um teste para cada tipo de expressao
- [X] Criado testes para testar o PPVisitor
   - Pretty print de listas seguem o padrão do haskell
   - Criado um teste completo para cada tipo de expressao
- [ ] Implementar um parser 

##### Data de entrega
08/06/2016

##### Grupo
Pedro Yan Ornelas  14/0158995 ,Pietro Bertarini 14/0159118
