# Meu Currículo 📱💫

Eu desenvolvi um aplicativo de currículo em **Java**, utilizando o **Android Studio**. O design do aplicativo foi inspirado no **Windows 98**, que foi o sistema operacional do primeiro computador que usei para jogar **Tomb Raider** (espero não estar confundindo as versões, haha). Acredito que foi nessa época que me apaixonei por games e tecnologia, graças à influência da minha irmã e do seu namorado, que hoje é seu marido.

Por isso, decidi criar o design do app nesse estilo **retrô**, em homenagem a essas memórias. Este aplicativo serve como uma vitrine de tudo o que sei fazer, destacando minhas **habilidades**, **conhecimentos** e **experiências**. Ele foi projetado para ser prático e funcional para **recrutadores** ou qualquer pessoa interessada no meu perfil.

## Funcionalidades principais:
- O aplicativo lista todas as **tecnologias** e **idiomas** que eu domino, facilitando a visualização de minhas competências.
- Inclui um **link direto para o meu LinkedIn**, permitindo que os recrutadores vejam mais detalhes sobre minha carreira e qualificações.
- Possui um **QR code** que, ao ser escaneado, dá acesso ao meu currículo em PDF. Além disso, existe a opção de **baixar o currículo** diretamente pelo app, permitindo que os recrutadores o salvem em seus dispositivos para consulta posterior.
- O app acessa todos os meus **projetos no GitHub** via API, oferecendo também a opção de visitar diretamente o meu perfil no GitHub, onde compartilho todos os meus projetos de código aberto.
- Para facilitar a navegação, o aplicativo possui uma **seção de tutorial**, explicando de forma simples como utilizar todas as suas funcionalidades.

## Testes Automatizados 🚀
Para garantir a qualidade e a confiabilidade do aplicativo, implementei um teste automatizado simples utilizando **JUnit 4** e **Espresso** para a interface de usuário da activity `HelpActivity`, onde verifico se o campo que exibe a hora é atualizado corretamente.

## Teste de UI: Atualização do Texto de Hora ⏲️
O teste `HelpActivityTest` simula o comportamento da interface de usuário e valida se a hora exibida no TextView da tela de ajuda é atualizada conforme esperado. O teste segue o seguinte fluxo:
- **Inicia a** `HelpActivity`: Usando o `ActivityScenario` para abrir a tela.
- **Verifica a visibilidade do TextView:** Certifica-se de que o componente que exibe a hora está visível para o usuário.
- **Aguarda a atualização da hora:** Utiliza uma pausa para permitir que o TextView seja atualizado.
- **Compara a hora exibida:** Obtém a hora formatada no padrão `HH:mm:ss` e compara com o valor exibido no TextView.

Esse aplicativo é uma maneira prática de mostrar meu trabalho e minhas qualificações, garantindo que os recrutadores tenham todas as informações que precisam ao alcance das mãos, de forma rápida e intuitiva.


