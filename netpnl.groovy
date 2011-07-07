#!/usr/bin/env groovy

def profitOrLoss
def grossPnL
def numberOfContracts
def rtCommissions
def console = System.console()

while(!['-', '+'].contains(profitOrLoss)) {
   profitOrLoss = console.readLine("> Enter '+' (for profit) or '-' (for loss)): ")
}
while(!grossPnL?.isBigDecimal()) {
   grossPnL = console.readLine('> Enter Gross PnL for the day: ')
}
while(!numberOfContracts?.isInteger()) {
   numberOfContracts = console.readLine('> Enter number of contracts traded for the day: ')
}
while(!rtCommissions?.isBigDecimal()) {
   rtCommissions = console.readLine('> Enter R/T commisions per contract: ')
}

def totalCommissions = rtCommissions.toBigDecimal() * numberOfContracts.toInteger()
def netPnL = (profitOrLoss == '+') ? grossPnL.toBigDecimal() - totalCommissions : grossPnL.toBigDecimal() + totalCommissions

println "Your total Net PnL for the day is ====================> $profitOrLoss\$$netPnL (with \$$totalCommissions of commissions cost)"