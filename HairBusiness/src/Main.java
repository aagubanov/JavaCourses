void main()
{
  final int RequiredInputLinesNumber = 2;
  final String InputFileName = "INPUT.TXT";
  final String OutputFileName = "OUTPUT.TXT";

  String[] inputLines = Utils.readInputFile(InputFileName, RequiredInputLinesNumber);
  if (inputLines == null)
  {
    return;
  }

  // First line: the number of days
  int lineNumbersCount = 1;
  int[] lineNumbers = Utils.getIntegersFromLine(inputLines[0], lineNumbersCount);
  if (lineNumbers == null)
  {
    return;
  }

  int numberOfDays = lineNumbers[0];

  // Second line: prices for every day (0 in case of an error)
  lineNumbersCount = numberOfDays;
  int[] prices = Utils.getIntegersFromLine(inputLines[1], lineNumbersCount, 0);
  if (prices == null)
  {
    return;
  }

  int maxIncome = calculateMaxIncome(numberOfDays, prices);
  Utils.writeOutputFile(OutputFileName, String.valueOf(maxIncome));
}

private int calculateMaxIncome(int numberOfDays, int[] prices)
{
  // Every centimeter should be sold by the maximum price over the remaining days
  int maxRemainingPrice = 0;
  int income = 0;

  for (int i = numberOfDays - 1; i >= 0; i--)
  {
    int dayPrice = prices[i];
    if (dayPrice > maxRemainingPrice)
    {
      // The last-night centimeter is sold by the highest available price
      maxRemainingPrice = dayPrice;
    }
    // else the last-night centimeter will be sold later by the highest available price

    income += maxRemainingPrice;
  }

  return income;
}