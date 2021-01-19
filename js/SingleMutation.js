function singleMutation(str1, str2){
    if(Math.abs(str2.length-str1.length)>1)
        return false;

    let mutations = 0;

    for(let i=0, j=0;i<str1.length || j<str2.length ;i++,j++){
        if(str1[i]!=str2[j]) {
            mutations++;
            if (mutations > 1)
                return false;

            if (str1.length > str2.length)
                j--;
            else if (str1.length < str2.length)
                i--;
        }
    }
    return true;
}
