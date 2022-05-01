import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html'
})
export class CarouselComponent implements OnInit {

  images = ["assets/images/lostark.jpg", "assets/images/archeAge.jpg", "assets/images/pokemonArceus.jpg"]

  constructor(private _config : NgbCarouselConfig) { }

  ngOnInit(): void {
  }

}
