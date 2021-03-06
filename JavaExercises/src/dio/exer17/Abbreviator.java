/*
Desafio
Leonardo é um nômade digital e viaja pelo mundo programando em diferentes cafés das cidades por onde passa. Recentemente, resolveu criar um blog, para compartilhar suas experiências e aprendizados com seus amigos.

Para criação do blog, ele optou por utilizar uma ferramenta pronta, que há um limite de caracteres que se pode escrever por dia, e Leonardo está preocupado que essa limitação, afinal, irá impedir de contar suas melhores experiências. Para contornar esse problema, decidiu usar um sistema de abreviação de palavras em seus posts.

O sistema de abreviações é simples e funciona da seguinte forma: para cada letra, é possível escolher uma palavra que inicia com tal letra e que aparece no post. Uma vez escolhida a palavra, sempre que ela aparecer no post, ela será substituída por sua letra inicial e um ponto, diminuindo assim o número de caracteres impressos na tela.

Por exemplo, na frase: “hoje eu programei em Python”, podemos escolher a palavra “programei” para representar a letra ‘p', e a frase ficará assim: “hoje eu p. em Python”, economizando assim sete caracteres. Uma mesma palavra pode aparecer mais de uma vez no texto, e será abreviada todas as vezes. Note que, se após uma abreviação o número de caracteres não diminuir, ela não deve ser usada, tal como no caso da palavra “eu” acima.

Leonardo precisa que seu post tenha o menor número de caracteres possíveis, e por isso pediu a sua ajuda. Para cada letra, escolha uma palavra, de modo que ao serem aplicadas todas as abreviações, o texto contenha o menor número de caracteres possíveis.

Entrada
Haverá diversos casos de teste. Cada caso de teste é composto de uma linha, contendo uma frase de até 10⁴ caracteres. A frase é composta de palavras e espaços em branco, e cada palavra é composta de letras minúsculas ('a'-'z'), e contém entre 1 e 30 caracteres cada.

O último caso de teste é indicado quando a linha dada conter apenas um “.”, o qual não deverá ser processado.

Saída
Para cada caso de teste, imprima uma linha contendo a frase já com as abreviações escolhidas e aplicadas.

Em seguida, imprima um inteiro N, indicando o número de palavras em que foram escolhidas uma letra para a abreviação no texto. Nas próximas N linhas, imprima o seguinte padrão “C. = P”, onde C é a letra inicial e P é a palavra escolhida para tal letra. As linhas devem ser impressas em ordem crescente da letra inicial.


 */


package exer.dio.exer17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Abbreviator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence;
        List<String> sentencesList = new ArrayList<>();

        while (!(sentence = br.readLine().toLowerCase(Locale.ROOT)).equals(".")){
            sentencesList.add(sentence);
        }
        for (String words : sentencesList){
            abbreviate(words);
        }

    }

    public static void abbreviate(String sentence){
        long abbreviationCounter = 0;
        String biggestWord = null;
        String biggestWordAbbreviation = "";
        List<String> wordList = List.of(sentence.split(" "));

        for(String word : wordList){
            if (biggestWord==null) biggestWord = word;
            else if (word.length()>biggestWord.length()) biggestWord = word;
        }

        biggestWordAbbreviation = biggestWord.substring(0,1) + ".";

        for (String word: wordList){
            if (word.equals(biggestWord)){
                System.out.print(biggestWordAbbreviation + " ");
                abbreviationCounter++;
            } else {
                System.out.print(word + " ");
            }
        }

        System.out.println();
        System.out.println(abbreviationCounter);
        System.out.println(biggestWordAbbreviation + " = " + biggestWord);
    }


}