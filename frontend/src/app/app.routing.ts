import { Routes, RouterModule } from '@angular/router';



const appRoutes = [
    { path: '', redirectTo: 'books', pathMatch: 'full' }
]

export const routing = RouterModule.forRoot(appRoutes);