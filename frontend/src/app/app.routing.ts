import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component';

//aquí tenemos que completar todo lo que queremos que se vaya cargando en el router-outlet
//ojo, el template no debe llamar al servicio, hay que hacerlo a través del componente

const appRoutes = [
    { path: 'home', component: HomeComponent }
]

export const routing = RouterModule.forRoot(appRoutes);
