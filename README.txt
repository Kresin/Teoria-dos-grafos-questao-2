Alunos: Gabriel Kresin e Iago G. Thambosi

Enunciado:
Implementeo algoritmo A* para resolver o cenário do labirinto entre a Origem (O) e o Destino (☺). Mostre o caminho e
o custo total entre a origem e o destino. Como heurística(H)utilize a distância de Manhattan. Para o cálculo da
distância você deve considerar apenas os quadrados/posições em branco. Cada ação de movimentação no grid
(acima, abaixo, esquerda ou direita) terá custo 1.

Ideia de solução:
Criar uma matriz de números com o labirinto onde:
    * -1 é instransponível
    * 0 = caminho normal
    * 1 = destino

Implementar função para encontrar o caminho;
Implementar função para calcular a distância;
Implementar função para cálcular a heurística;