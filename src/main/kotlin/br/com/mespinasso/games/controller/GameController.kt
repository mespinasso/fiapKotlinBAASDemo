package br.com.mespinasso.games.controller

import br.com.mespinasso.games.model.Game
import br.com.mespinasso.games.service.GameServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = "/game")
class GameController {

    @Autowired
    lateinit var gameServices: GameServices

    @GetMapping
    fun buscarTodos(): List<Game> {
        return gameServices.buscarTodos()
    }

    @PostMapping
    fun salvar(@RequestBody game: Game) {
        gameServices.salvar(game)
    }

    @GetMapping(value = "/titulo/{titulo}")
    fun buscarPor(@PathVariable(value = "titulo") titulo: String) : List<Game> {
        return gameServices.buscarPor(nome = titulo)
    }

    @DeleteMapping(value = "{id}")
    fun apagar(@PathVariable(value = "id") id : String) {
        gameServices.apagar(id)
    }
}