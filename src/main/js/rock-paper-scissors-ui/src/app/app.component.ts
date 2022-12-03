import {Component} from '@angular/core';
import {AppService} from './app.service';
import {Game} from './game';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'rock-paper-scissors-ui';

  constructor(private appService: AppService) {}

  scores = {
    computer: 0,
    person: 0
  };

  computer: any = false;
  person: any = false;

  play(move: string) {
    this.playOnServer({
      playerOneName: 'Victor',
      playerOneMove: move.toUpperCase(),
      computerName: 'Super Computer'
    });
  }

  playOnServer(game: Game) {
    this.appService.play(game).subscribe({
      next: game => {
        // next
        switch(game.score) {
          case 'COMPUTER_WIN':
            this.scores.computer++;
            break
          case 'PLAYER_ONE_WIN':
            this.scores.person++;
            break
          default:
            // draw
        }
        this.computer = game.computerMove?.toLowerCase();
        this.person = game.playerOneMove?.toLowerCase();
      },
      error: error => {
        // handle error
      }
    })
  }

  reset() {
    this.computer = false;
    this.person = false;
    this.scores.computer = 0;
    this.scores.person = 0;
  }
}
