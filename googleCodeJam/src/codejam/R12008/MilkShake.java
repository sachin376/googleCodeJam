package codejam.R12008;

import java.util.*;
import java.io.*;

public class MilkShake {

  private final int UNMALTED = 0;
  private final int NOCHOICE = 2;
  private boolean isPossible;
  private ArrayList<ArrayList<Integer>> customerPreferenceList = new ArrayList<ArrayList<Integer>>();
  private int[] finalBatchAr;
  private StringBuilder result = new StringBuilder();

  public static void main(String[] args) {
    new MilkShake().go();
  }

  public void go() {

  File inputFile = new File("/* File name */");
  BufferedReader br = null;

    try {

      br = new BufferedReader(new FileReader(inputFile));
      int numTests = Integer.parseInt(br.readLine());

      //Loop through each test
      for(int testCounter = 0; testCounter < numTests; ++testCounter) {
        customerPreferenceList.clear();
        int numFlavors = Integer.parseInt(br.readLine());
        initializeFlavorAr(numFlavors);

        int numCustomers = Integer.parseInt(br.readLine());
        isPossible = true;

        //For each test, loop through each customer
        for(int customerCounter = 0; customerCounter < numCustomers; ++customerCounter) {
          String[] customerPrefs = br.readLine().split(" ");
          ArrayList<Integer> custRow = new ArrayList<Integer>();

          for(int j = 0; j < customerPrefs.length; ++j) {
            custRow.add(Integer.parseInt(customerPrefs[j]));
          }
          customerPreferenceList.add(custRow);
        }

        //Eliminate first element of each row. Number of elements each customer likes is not used.
        if(!customerPreferenceList.isEmpty()) {
          for(ArrayList<Integer> a : customerPreferenceList) {
            if(!a.isEmpty()) { a.remove(0); }
          }
        }

        boolean customerPreferenceListChanged = true;

        while(customerPreferenceList.size() > 0 && isPossible && customerPreferenceListChanged == true) {
          customerPreferenceListChanged = false;
          ArrayList<Integer> removeList = new ArrayList<Integer>();

          //Deal with rows with only one choice
          for(int oneChoiceCounter = 0; oneChoiceCounter < customerPreferenceList.size(); ++oneChoiceCounter) {
            if(customerPreferenceList.get(oneChoiceCounter).size() == 2) {
              int indexOfFlavorInQuestion = customerPreferenceList.get(oneChoiceCounter).get(0);
              if(finalBatchAr[indexOfFlavorInQuestion - 1] == NOCHOICE) {
                finalBatchAr[indexOfFlavorInQuestion - 1] = customerPreferenceList.get(oneChoiceCounter).get(1);
                removeList.add(oneChoiceCounter);
                customerPreferenceListChanged = true;
              }
              else if(finalBatchAr[indexOfFlavorInQuestion - 1] != customerPreferenceList.get(oneChoiceCounter).get(1)) {
                isPossible = false;
                break;
              }
              else {
                //flavor already in map - remove from customerPreferenceList
                removeList.add(oneChoiceCounter);
                customerPreferenceListChanged = true;
              }
            }
          }

          if(!removeList.isEmpty()) {
            cleanUpCustomerPreferenceList(removeList);
            removeList.clear();
          }

          //Loop through all other cases, if any element already in finalBatchAr remove the row from customerPreferenceList
          for(int elementExistsCounter = 0; elementExistsCounter < customerPreferenceList.size(); ++elementExistsCounter) {
            for(int j = 0; j < customerPreferenceList.get(elementExistsCounter).size(); j += 2) {
              if(finalBatchAr[customerPreferenceList.get(elementExistsCounter).get(j) - 1] == customerPreferenceList.get(elementExistsCounter).get(j + 1)) {
                removeList.add(elementExistsCounter);
                customerPreferenceListChanged = true;
                break;
              }
            }
          }

          if(!removeList.isEmpty()) {
            cleanUpCustomerPreferenceList(removeList);
            removeList.clear();
          }

          //Loop through customerPreferenceList again, get rid of all elements that conflicts with finalBatchAr
          //If currentRow empty afterwards, set isPossible to false
          for(int conflictCounter = 0; conflictCounter < customerPreferenceList.size(); ++conflictCounter) {
            int currentRowSize = customerPreferenceList.get(conflictCounter).size();

            for(int j = 0; j < currentRowSize; j += 2) {
              if((finalBatchAr[customerPreferenceList.get(conflictCounter).get(j) - 1] != NOCHOICE) && (finalBatchAr[customerPreferenceList.get(conflictCounter).get(j) - 1] != customerPreferenceList.get(conflictCounter).get(j + 1))) {
                customerPreferenceList.get(conflictCounter).remove(j);
                customerPreferenceList.get(conflictCounter).remove(j);
                j -= 2;
                currentRowSize -= 2;
                customerPreferenceListChanged = true;
              }
            }

            if(customerPreferenceList.get(conflictCounter).size() == 0) {
              isPossible = false;
              break;
            }

          }
        }

        finalizeFlavorAr(numFlavors);
        appendResult(testCounter + 1, numFlavors);
      }
    } catch(FileNotFoundException fe) {
        fe.printStackTrace();
    } catch(IOException ie) {
        ie.printStackTrace();
    } finally {
        try {
          if(br != null) {
             br.close();
          }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    writeResultToFile();
  }

  private void initializeFlavorAr(int numFlavors) {
    finalBatchAr = null;
    finalBatchAr = new int[numFlavors];

    for(int i = 0; i < numFlavors; ++i) {
      finalBatchAr[i] = NOCHOICE;
    }

  }

  private void finalizeFlavorAr(int numFlavors) {
    for(int i = 0; i < numFlavors; ++i) {
      if(finalBatchAr[i] == NOCHOICE) {
        finalBatchAr[i] = UNMALTED;
      }
    }
  }

  private void appendResult(int testCase, int numFlavors) {

    result.append("Case #" + testCase + ": ");

    if(!isPossible) {
      result.append("IMPOSSIBLE");
    }
    else {
      for(int i = 0; i < finalBatchAr.length; ++i) {
        result.append(finalBatchAr[i] + " ");
      }
    }
    result.append("\n");
  }

  private void writeResultToFile() {
    PrintWriter pr = null;

    try {
      pr = new PrintWriter(new File("/* File name */"));
      pr.print(result);

    } catch(FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        if(pr != null) {
          pr.close();
        }
    }
  }

  private void cleanUpCustomerPreferenceList(ArrayList<Integer> removeList) {
    for(int i = 0; i < removeList.size(); ++i) {
      int removeIndex = removeList.get(i);
      customerPreferenceList.remove(removeIndex - i);
    }
  }
}