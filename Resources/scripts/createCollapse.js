function animate() {
  var element = $('create-question-form');
  var opacity = element.getOpacity() + 0.1;
  element.setStyle({'display': 'block', 'opacity': opacity});
  if(opacity < 1) {
    setTimeout(animate, 50);
  }
}

function animateShow() {
  var element = $('create-question-form');
  element.setStyle({'display': 'block', 'opacity': 0.0});
  setTimeout(animate, 50);
}

function showCreate() {
	$('create-question-form').show();
	$('create-button').hide();
	$('hide-button').show();
	animateShow();
}

function hideCreate() {
	$('create-question-form').hide();
	$('create-button').show();
	$('hide-button').hide();
}
