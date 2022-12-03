import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'rock-paper-scissors-ui';

  scores = {
    computer: 0,
    person: 0
  };

  computer: any = false;
  person: any = false;

  choices = ['rock', 'paper', 'scissors'];

  random() {
    return Math.floor(Math.random() * this.choices.length);
  }

  play(answer: string) {
    const computer = this.choices[this.random() | 0];
    const match = computer + '_' + answer;
    console.log('computer', computer);
    switch(match) {
      case 'rock_paper':
      case 'paper_scissors':
      case 'scissors_rock':
        console.log('Computer loses!');
        console.log('You win!');
        this.scores.person++;
        break;
      case 'paper_rock':
      case 'scissors_paper':
      case 'rock_scissors':
        console.log('Computer wins!');
        console.log('You lose!');
        this.scores.computer++;
        break;
      default:
        console.log('Draw!');
        this.scores.computer++;
        this.scores.person++;
    }

    this.computer = computer;
    this.person = answer;

  }

  reset() {
    this.computer = false;
    this.person = false;
    this.scores.computer = 0;
    this.scores.person = 0;
  }
}
