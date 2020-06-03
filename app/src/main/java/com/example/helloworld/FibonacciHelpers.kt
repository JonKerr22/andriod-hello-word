package com.example.helloworld

fun fibCalc(numberToGo: Int): Int{
    if(numberToGo == 0){
        return 0
    }
    else if(numberToGo == 1){
        return 1
    }
    return fibCalcRecurse(numberToGo -2 , 0,1)
}

private fun fibCalcRecurse(stepsLeft: Int, prevNum: Int, currNum: Int): Int{
    if(stepsLeft == 0) return  currNum
    val nextNum = prevNum + currNum
    return fibCalcRecurse(stepsLeft -1, currNum, nextNum)
}