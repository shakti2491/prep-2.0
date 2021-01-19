function allAnagrams(strings){
    const sortedStrings = strings.map(str => str.split('').sort().join(''));

    for(let i =1;i<strings.length;i++){
        if(sortedStrings[i] !== sortedStrings[0])
            return false;
    }
    return true;
}
