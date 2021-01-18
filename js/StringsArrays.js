function isUnique(str){
    const chars = new Set();
    for(let i=0;i<str.length;i++){
        const thisChar = str[i];
        if(chars.has(thisChar))
            return false;
        chars.add(thisChar)
    }
}

function flatten(nestedArray) {
   const newArray = [];
   for(let i =0; i<nestedArray.length;i++){
       const thisItem = nestedArray[i];
       if(Array.isArray(thisItem)){
           const flatItem = flatten(thisItem);
           for(let j =0;j<thisItem.length;j++){
               newArray.push(flatItem[j]);
           }
       }else{
           newArray.push(thisItem);
       }
   }
   return newArray;
}


function removeDupes(str){
    const uniqueCharacters = new Set(str);
    return Array.from(uniqueCharacters).join('');
}


function highestFrequency(strings){
    const frequencies = {};
    let maxFrequency = 0;
    let mostFrequentString = string[0];

    for(let i =0;i<strings.length;i++){
        const thisStr = strings[i];

        if(frequencies[thisStr] === undefined){
            frequencies[thisStr] = 1;
        }else{
            frequencies[thisStr]++;
        }
        if(frequencies[thisStr]>maxFrequency){
            maxFrequency = frequencies[thisStr];
            mostFrequentString = thisStr;
        }
    }
    return mostFrequentString;
}

function rotation(str1, str2){
    return str1.length === str2.length && (str2+str2).includes(str1);
}


console.log(rotation("rotation" ,"tionrota"));
