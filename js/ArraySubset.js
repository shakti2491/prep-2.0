function arraySubset(arr,sub){
    if(sub.length > arr.length)
        return false;

    for(let i =0; i<sub.length;i++){
        const arrIndex = arr.indexOf(sub[i]);
        if(arrIndex == -1)
            return false;

        delete arr[arrIndex];
    }

    return true;
}


function arraySubsetMap(arr, sub){

    const arrMap = new Map();

    for(let i =0;i<arr.length;i++){
        const item  = arr[i];
        if(arrMap.has(item)){
            arrMap.set(item,arrMap.get(item)+1);
        }else{
            arrMap.set(item,1);
        }
    }

    for(let i=0;i<sub.length;i++){
        const currItem = sub[i];
        if(!arrMap.has(currItem)){
            return false;
        }
        arrMap.set(currItem,arrMap.get(currItem)-1);
        if(arrMap.get(currItem)===-1)
            return false;
    }

}
