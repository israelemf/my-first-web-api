# Spring Web

Quando falamos de Spring Web, temos dois direcionamentos, o famoso MVC, que é o ecossistema de Model, View e Controller
que é a concepção das nossas páginas, ou só uma concepção de REST API.

Nesse projeto teremos um exemplo de uma API REST desenvolvida com Spring Web e documentada com Swagger.

### MVC
- Voltado a uma aplicação Web com interfaces gráficas, páginas.
### API REST
- Camada de disponibilização de recursos, ou API's diante da arquitetura REST.

## API
- Uma API (Interface Application Program) é um programa que faz a "ponte" de comunicação entre duas
aplicações distintas.

## REST e RESTful
Uma API **REST** (Representational State Transfer) é como um guia de boas práticas, e o **RESTful**
é a capacidade de determinado sistema aplicar os principios **REST**.

Nem todas as API's ou Webservices existentes estão aderentes aos conceitos **REST**.

### Princípios REST
Para uma arquitetura de sistema ser considerada RESTful, é necessário seguir uma série de padrões.

- **cliente-servidor**
  - Significa aprimorar a portabilidade entre várias plataformas de interface do usuário e do servidor, permitindo
uma evolução independente do sistema. Precisamos de uma interação mais simples entre a camada da API com o sistema 
que solicita.
- **interface uniforme**
  - Representa uma única forma de interação entre cliente e servidor. Para isso, é preciso ter uma interface que 
identifique e represente recursos, mensagens autodescritivas, bem como hypermedia (HATEOAS).
- **stateless**
  - Indica que cada interação via API tenha acesso a dados completos e compreensíveis. Cada requisição deve ter uma perspectiva
de retornar todos os dados para aquele contexto.
- **cache**
  - Necessário para reduzir o tempo médio de resposta, melhorar a eficiência, desempenho e escalabilidade da comunicação.
  - Em alguns momentos nossa API terá a capacidade de deixar pré-fornecido alguns recursos, para que não seja necessário
um processamento a cada requisição.
- **camadas**
  - Permite que a arquitetura seja menos complexa e altamente flexível.

### Nível de Maturidade
Existe um modelo de maturidade para esse tipo de API, proposto por Leonard Richardson, que é definido em 4 níveis.

<img src="./img_readme/nivel_maturidade.webp">

- Nivel 0: Ausência de Regras
  <img src="./img_readme/nivel0.webp">
  - Considerado o nível mais básico, uma API que só segue esse padrão não é considerada REST.
  - Um único verbo com nomes que não seguem nenhum padrão.

- Nível 1: Aplicação de Resources
  <img src="./img_readme/nivel1.webp">
  - Nesse nível, o nome dos recursos foram equalizados, e para não gerar ambiguidade é necessário definir o verbo apropriado.

- Nível 2: Implementação de verbos HTTP
  <img src="./img_readme/nivel2.webp">
  - Como a definição dos verbos já são realizadas no Nível 1, o Nível 2 se encarrega de validar a aplicabilidade dos verbos
para finalizadades específicas.

- Nível 3: HATEOAS
  - Raramente implementada em API's, fornece em cada requisição, links que indicarão como poderá ser feita a navegação
entre seus recursos. Ou seja, quem for consumir a API precisará saber apenas a rota principal e a resposta dessa requisição
fornecerá todas as demais rotas possíveis.
  
  <img src="./img_readme/nivel3.webp">
  
  - Acima, um resultado de uma API que implementa HATEOAS, em cada resposta existe uma collection de links.

## Controller
Um Controller é um recurso que disponibiliza funcionalidades de negócio da aplicação através do protocolo HTTP,
conforme exemplo visto abaixo:

```
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to a Spring Boot REST API";
    }
}
```

### Rest Controller
Um Rest Controller em Spring nada mais é que uma classe contendo anotações específicas para disponibilizar
recursos HTTP com base em nossos serviços e regras de negócio.

Anotações e configurações mais comuns:

- @RestController
  - Responsável por designar o bean de compoment, que suporta requisições HTTP com base na arquitetura REST.
- @RequestMapping("prefix")
  - Determina qual a URI comum para todos os recursos disponibilizados pelo Controller.
- @GetMapping
  - Determina que o método aceitará requisições HTTP do tipo GET.
- @PostMapping
  - Determina que o método aceitará requisições HTTP do tipo POST.
- @PutMapping 
  - Determina que o método aceitará requisições HTTP do tipo PUT.
- @DeleteMapping
  - Determina que o método aceitará requisições HTTP do tipo DELETE.
- @RequestBody
  - Converte um JSON para o tipo do objeto esperado como parâmetro no método.
- @PathVariable 
  - Consegue determinar que parte da URI será composta por parâmetros recebidos nas requisições.