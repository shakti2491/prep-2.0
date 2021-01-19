function rotateClockwise(matrix){
    const newMatrix = matrix.map(()=>[]);
    const newMatrix1 = matrix[0].map(()=>[]);
    for(let i=0;i<matrix.length;i++){
        for(let j=0;j<matrix[0].length;j++){
            newMatrix[j][matrix.length-1-i] = matrix[i][j];
        }
    }
    return newMatrix;
}

function rotate180(matrix) {
    return rotateClockwise(rotateClockwise(matrix));
}

function rotateCounterClockwise(matrix) {
    return rotateClockwise(rotate180(matrix));
}
rotateClockwise([[1, 2, 3], [4, 5, 6]]);


function rotateInPlaceSquareMatrix(matrix){
    const totalLayers = Math.floor(matrix.length/2);

    for(let layer = 0; layer<totalLayers;layer++){
        const lastIndex = matrix.length-1-layer;
        for(let forwardIterator = layer+1; forwardIterator<matrix.length-layer;forwardIterator++){
            
        }
    }
}
