function movieList() {

	// Gets all H2s in HTML
	allH2s = document.querySelectorAll('.container > h2');

	// Uses GSAP to fade in all H2s
	gsap.to(allH2s, {
		opacity : 1,
		duration : 1,
		stagger : 1,
		onComplete : fadeInUl
	}, .2);
	
	// Fades in ULs
	function fadeInUl() {

		movieInfo = document.querySelectorAll('.movieInfo');

		gsap.to(movieInfo, {
			opacity : 1,
			duration : 1
		});

	}
}
