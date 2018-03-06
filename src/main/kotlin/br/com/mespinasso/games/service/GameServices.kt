package br.com.mespinasso.games.service

import br.com.mespinasso.games.model.Game
import br.com.mespinasso.games.repository.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable

@Service
class GameServices {

    @Autowired
    lateinit var gameRepository : GameRepository

    fun buscarTodos() : List<Game> {
        return gameRepository.findAll()
    }

    fun salvar(game: Game) {
        gameRepository.save(game)
    }

    fun buscarPor(nome: String) : List<Game> {
        return gameRepository.findByNomeIgnoreCaseContaining(nome)
    }

    fun apagar(id: String) {
        gameRepository.deleteById(id)
    }
}