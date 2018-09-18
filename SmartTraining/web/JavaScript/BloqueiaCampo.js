let instrutorEl = document.getElementById('radioInst');
let alunoEl = document.getElementById('radioAl');
instrutorEl.addEventListener('click', isInstrutor);
alunoEl.addEventListener('click', isInstrutor);

function formatar(mascara, documento){
  var i = documento.value.length;
  var saida = mascara.substring(0,1);
  var texto = mascara.substring(i)

  if (texto.substring(0,1) != saida){
            documento.value += texto.substring(0,1);
  }
}

function isInstrutor(){
    if(instrutorEl.checked){
        document.getElementById('cref').removeAttribute("disabled","");
        document.getElementById('acao').value = "CadastrarInstrutor";
    }else{
        document.getElementById('cref').setAttribute("disabled","");
        document.getElementById('acao').value = "CadastrarAluno";
    }
}