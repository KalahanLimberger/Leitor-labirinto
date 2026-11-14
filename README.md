# Resolvedor de Labirinto em Java

Programa em Java que lê um labirinto a partir de um arquivo de texto e encontra um caminho até a saída usando **recursão** e **backtracking**.

## Como funciona

O labirinto é carregado de um arquivo `.txt` e armazenado em uma matriz de caracteres. A busca começa na posição `(0, 0)` e tenta se mover para cima, para baixo, para a esquerda e para a direita, nessa ordem. Quando um caminho não leva a lugar nenhum, o algoritmo volta atrás (backtracking) e tenta outra direção. Se chegar na saída, o caminho percorrido fica marcado no labirinto.

### Legenda dos caracteres

| Caractere | Significado |
|-----------|-------------|
| `X` | Parede |
| ` ` (espaço) | Caminho livre |
| `D` | Destino (saída) |
| `+` | Caminho encontrado (apenas na impressão do resultado) |

## Estrutura do projeto

```
.
├── Main.java        # Ponto de entrada: carrega, resolve e imprime o labirinto
├── Labirinto.java   # Leitura do arquivo, algoritmo de busca e impressão
└── labirinto.txt    # Labirinto de exemplo
```

### Principais métodos de `Labirinto`

- `criaLabirinto(String filename)`: lê o arquivo e monta a matriz do labirinto.
- `percorreLabirinto()`: inicia a busca recursiva a partir de `(0, 0)` e retorna `true` se existir uma saída.
- `imprimeLabirinto()`: imprime o estado atual do labirinto no console.

## Como executar

**Pré-requisito:** JDK 8 ou superior instalado.

```bash
# Compilar
javac Main.java Labirinto.java

# Executar (o arquivo labirinto.txt deve estar na pasta atual)
java Main
```

## Exemplo de entrada (`labirinto.txt`)

```
 XXXXXXXXXX   XXXXXX
 XXXXXXXXXX X   XXXX
    XXXXXXX XXX XXXX
XXX XXXXXX  XXX XXXX
XXX    XX  XXXX     
XXX XX X  XXXXX XXX 
XXXXXX   XXXXXX XX  
XXXXXX X XXXXXX XXXD
```

## Saída esperada

Se houver caminho, o programa imprime o labirinto original, a mensagem `Existe uma saída do labirinto!` e o labirinto com o trajeto marcado com `+`. Caso contrário, imprime `Labirinto sem saída!`.

## Observações

- A posição inicial é sempre o canto superior esquerdo `(0, 0)`, que precisa ser um espaço livre.
- O algoritmo encontra **um** caminho válido, não necessariamente o mais curto.
- As linhas do arquivo devem ter o mesmo comprimento.

## Conceitos praticados

- Recursão e backtracking
- Leitura de arquivos com `BufferedReader` / `FileReader`
- Manipulação de matrizes bidimensionais
- Tratamento de exceções (`IOException`)

## Autor

Kalahan Limberger
