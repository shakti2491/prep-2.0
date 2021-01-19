function addFactory(storedNum){
    return function (num){
        return num+storedNum;
    }
}


const add10 = addFactory(10);
const add20 = addFactory(20);

const num = add10(13);
const num2 = add20(14);


function counterGenerator() {
    let counter = 1;
     return function(){
         return counter++;
     }
}
abc = 10
const incrementCounter = counterGenerator();
console.log(incrementCounter())
