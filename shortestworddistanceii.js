//Objective is to design a class that has one method: 'shortest'
//'Shortest' takes 2 words and finds the shortest distance between them

let words = ["practice", "makes", "perfect", "coding", "makes"]


//Design of a class using a hashmap to keep track of indices
//We use two pointers to traverse over both word arrays
//and update the min distance.

class WordDistance {
    constructor(words) {
        this.map = {}

        for (let i = 0; i < words.length; i++) {
            if (this.map[words[i]] == undefined) {
                this.map[words[i]] = [i]
            } else {
                this.map[words[i]].push(i)
            }
        }
    }

    shortest(word1, word2) {
        let array1 = this.map[word1]
        let array2 = this.map[word2]
        let min = Infinity

        let i = 0
        let j = 0

        while (i < array1.length && j < array2.length) {
            let index1 = array1[i]
            let index2 = array2[j]

            min = Math.min(min, Math.abs(index2 - index1))

            if (index1 < index2) {
                i++
            } else {
                j++
            }
        }

        return min
    }
}

let newWords = new WordDistance(words)
newWords.shortest('practice', 'makes')