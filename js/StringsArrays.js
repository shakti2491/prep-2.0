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

console.log(flatten([ [ [ [1], 2], 3], [4], [], [[5]]]));
