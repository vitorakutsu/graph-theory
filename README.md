
# Teoria dos Grafos - Implementações em Java

Este repositório contém implementações de diversas aplicações relacionadas à **Teoria dos Grafos** utilizando a linguagem **Java**. O objetivo é fornecer uma base prática para quem deseja estudar, entender e aplicar conceitos fundamentais de grafos, como conectividade, busca em grafos, e detecção de tipos de grafos.

## Índice

- [Visão Geral](#visão-geral)
- [Funcionalidades Implementadas](#funcionalidades-implementadas)
- [Como Executar](#como-executar)
- [Estrutura do Projeto](#estrutura-do-projeto)

## Visão Geral

A **Teoria dos Grafos** é uma área da matemática que estuda estruturas formadas por nós (ou vértices) conectados por arestas. Grafos são amplamente utilizados em diversas áreas como redes de computadores, inteligência artificial, e otimização de rotas. Este repositório explora alguns dos principais algoritmos e propriedades de grafos por meio de código em Java.

## Funcionalidades Implementadas

Atualmente, as seguintes funcionalidades foram implementadas:

1. **Leitura de Matriz de Adjacência**: Leitura de uma matriz de adjacência a partir de um arquivo de texto.
2. **Verificação de Tipo de Grafo**:
   - Grafo simples
   - Grafo completo
   - Grafo regular
   - Grafo orientado
3. **Algoritmos Clássicos**:
   - Busca em Profundidade (DFS)
   - Busca em Largura (BFS)
   - Algoritmo de Dijkstra para o menor caminho
4. **Análise de Grafos**:
   - Detecção de ciclos
   - Verificação de conectividade
   - Classificação de nós
5. **Simulação de Tempo de Análise**: Utiliza um sistema de loading para simular a análise de grafos grandes.

## Como Executar

### Pré-requisitos

Para executar o projeto, você precisará ter o **Java 8** (ou superior) instalado. Você pode verificar a versão instalada com o seguinte comando:

```bash
java -version
```

### Passos

1. Clone este repositório:

```bash
git clone https://github.com/vitorakutsu/graph-theory.git
```

2. Navegue até o diretório do projeto:

```bash
cd teoria-dos-grafos-java
```

3. Compile os arquivos Java:

```bash
javac src/*.java
```

4. Execute a aplicação:

```bash
java src.Main
```

## Estrutura do Projeto

```bash
teoria-dos-grafos-java/
│
├── src/
│   ├── Assets                       
│   │    └── file.txt                
│   ├── DataStructure               
│   │    ├── List              
│   │    │   └── ArrayList.java     
│   │    │   └── List.java          
│   │    │   └── Node.java           
│   │    └── Matrix            
│   │        └── Matrix.java        
│   ├── File                   
│   │    └── File.java               
│   ├── Menu                   
│   │    └── Menu.java             
│   └── Main.java              
├── README.md                  
└── .gitignore                
```
