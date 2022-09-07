import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'player',
        data: { pageTitle: 'jhipsterCriteriaJpaSampleApp.player.home.title' },
        loadChildren: () => import('./player/player.module').then(m => m.PlayerModule),
      },
      {
        path: 'team',
        data: { pageTitle: 'jhipsterCriteriaJpaSampleApp.team.home.title' },
        loadChildren: () => import('./team/team.module').then(m => m.TeamModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
