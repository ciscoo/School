
import java.awt.Graphics;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francisco
 */
public class GameFrame extends javax.swing.JFrame {
    
    //Instance variable for the Hangman game
    private final Hangman game;
    private Graphics2D painter;

    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initComponents();
        game = new Hangman("HangmanLexicon.txt");
        game.setCompare(game.getIncorrentGuessesMade());
        painter = (Graphics2D) painter;
        lettersList.setText("Guessed letters: " + game.getGuessedLetters());
        lettersGuessed.setText(game.getCurrentState());
        guessRemaining.setText("You have " + game.getIncorrectGuessesRemaining() 
                               + " guesses left.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lettersGuessed = new javax.swing.JLabel();
        guessRemaining = new javax.swing.JLabel();
        lettersList = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        letterInput = new javax.swing.JTextField();
        endMessage = new javax.swing.JLabel();
        wordLabel = new javax.swing.JLabel();
        word = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman");

        lettersGuessed.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel4.setText("Enter in a letter");

        letterInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letterInputActionPerformed(evt);
            }
        });

        endMessage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        wordLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        word.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lettersGuessed, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guessRemaining)
                    .addComponent(lettersList)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(letterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(wordLabel)
                    .addComponent(word))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lettersGuessed)
                .addGap(18, 18, 18)
                .addComponent(guessRemaining)
                .addGap(18, 18, 18)
                .addComponent(lettersList)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letterInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(endMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(word)
                .addGap(26, 26, 26)
                .addComponent(wordLabel)
                .addContainerGap(280, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void letterInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letterInputActionPerformed
        
        //Boolean game over
        if (game.gameOver()) {
            
            //Clear out text field
            letterInput.setText("");
            
            //Disabled text field to prevent more input
            letterInput.setEnabled(false);
           
            //Set guesses remaining
            guessRemaining.setText("No guesses left!");
                    
            //Tell user they lost the game.
            endMessage.setText("YOU LOSE! The word was:");
            
            //Show the word
            word.setText(game.getWord());
            
        } else {
            
            //Update game stats
            updateDisplay();
        }
        
    }//GEN-LAST:event_letterInputActionPerformed

    // The main method that updates the display when user enters input
    // Called when !gameOver()
    public void updateDisplay () {
        game.update(letterInput.getText().toUpperCase().charAt(0));
        letterInput.setText("");
        lettersList.setText("Guessed letters: " + game.getGuessedLetters());
        guessRemaining.setText("You have " + game.getIncorrectGuessesRemaining() 
                               + " guesses left.");
        lettersGuessed.setText(game.getCurrentState());
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel endMessage;
    private javax.swing.JLabel guessRemaining;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField letterInput;
    private javax.swing.JLabel lettersGuessed;
    private javax.swing.JLabel lettersList;
    private javax.swing.JLabel word;
    private javax.swing.JLabel wordLabel;
    // End of variables declaration//GEN-END:variables
}
