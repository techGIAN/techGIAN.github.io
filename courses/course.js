(function () {

	if (typeof self === 'undefined' || !self.Prism || !self.document) {
		return;
	}

	/**
	 * Class name for <pre> which is activating the plugin
	 * @type {String}
	 */
	var PLUGIN_CLASS = 'line-numbers';

	/**
	 * Resizes line numbers spans according to height of line of code
	 * @param  {Element} element <pre> element
	 */
	var _resizeElement = function (element) {
		var codeStyles = getStyles(element);
		var whiteSpace = codeStyles['white-space'];

		if (whiteSpace === 'pre-wrap' || whiteSpace === 'pre-line') {
			var codeElement = element.querySelector('code');
			var lineNumbersWrapper = element.querySelector('.line-numbers-rows');
			var lineNumberSizer = element.querySelector('.line-numbers-sizer');
			var codeLines = element.textContent.split('\n');

			if (!lineNumberSizer) {
				lineNumberSizer = document.createElement('span');
				lineNumberSizer.className = 'line-numbers-sizer';

				codeElement.appendChild(lineNumberSizer);
			}

			lineNumberSizer.style.display = 'block';

			codeLines.forEach(function (line, lineNumber) {
				lineNumberSizer.textContent = line || '\n';
				var lineSize = lineNumberSizer.getBoundingClientRect().height;
				lineNumbersWrapper.children[lineNumber].style.height = lineSize + 'px';
			});

			lineNumberSizer.textContent = '';
			lineNumberSizer.style.display = 'none';
		}
	};

	/**
	 * Returns style declarations for the element
	 * @param {Element} element
	 */
	var getStyles = function (element) {
		if (!element) {
			return null;
		}

		return window.getComputedStyle ? getComputedStyle(element) : (element.currentStyle || null);
	};

	window.addEventListener('resize', function () {
		Array.prototype.forEach.call(document.querySelectorAll('pre.' + PLUGIN_CLASS), _resizeElement);
	});

	Prism.hooks.add('complete', function (env) {
		if (!env.code) {
			return;
		}

		// works only for <code> wrapped inside <pre> (not inline)
		var pre = env.element.parentNode;
		// Original regex check for class, leaving it here 
		// for its redundancy check
		var clsReg = /\s*\bline-numbers\b\s*/;
		// New regex check for opt-out class
		var clsRegB = /\s*\bno-line-numbers\b\s*/;

		if (env.element.querySelector(".line-numbers-rows")) {
			// Abort if line numbers already exists
			return;
		}
		
		// Added to facilitate opting out
		if (clsRegB.test(pre.className)) {
			// Respect the opt-out
			return;
		}

		if (clsReg.test(env.element.className)) {
			// Remove the class "line-numbers" from the <code>
			env.element.className = env.element.className.replace(clsReg, ' ');
		}
		if (!clsReg.test(pre.className)) {
			// Add the class "line-numbers" to the <pre>
			pre.className += ' line-numbers';
		}

		var match = env.code.match(/\n(?!$)/g);
		var linesNum = match ? match.length + 1 : 1;
		var lineNumbersWrapper;

		var lines = new Array(linesNum + 1);
		lines = lines.join('<span></span>');

		lineNumbersWrapper = document.createElement('span');
		lineNumbersWrapper.setAttribute('aria-hidden', 'true');
		lineNumbersWrapper.className = 'line-numbers-rows';
		lineNumbersWrapper.innerHTML = lines;

		if (pre.hasAttribute('data-start')) {
			pre.style.counterReset = 'linenumber ' + (parseInt(pre.getAttribute('data-start'), 10) - 1);
		}

		env.element.appendChild(lineNumbersWrapper);

		_resizeElement(pre);
	});

}());

document.addEventListener('DOMContentLoaded', function() {
	// var dtModifiedElement = document.getElementById('dtModified');
	
	// // Get last modified date of the current document
	// var lastModifiedDate = new Date(document.lastModified);
	
	// // Format the date as desired
	// var options = { 
	// 	year: 'numeric', 
	// 	month: 'short', // Use short month format (e.g., Jul)
	// 	day: '2-digit',  // Use 2-digit day format (e.g., 01)
	// 	hour: '2-digit', 
	// 	minute: '2-digit', 
	// 	hour12: true 
	// };
	// var formattedDate = lastModifiedDate.toLocaleDateString('en-US', options);
	
	// // Get the day suffix (st, nd, rd, th)
	// var day = lastModifiedDate.getDate();
	// var daySuffix = getDaySuffix(day);
	
	// // Construct final formatted string
	// // var finalFormattedDate = 'Last updated: ' + formattedDate.replace(',', '') + daySuffix + ' @ ' + formattedDate.slice(12);
	// var dateMod = formattedDate.split(',')[0] + daySuffix;
	// var yearMod = formattedDate.split(',')[1];
	// var timeMod = formattedDate.split(',')[2];
	// var finalFormattedDate = dateMod + ", " + yearMod;
	
	// // Update the text content of the dtModifiedElement
	// dtModifiedElement.textContent = "Last updated: " + finalFormattedDate;
	// dtModifiedElement.style.fontWeight = "bold";



	var coll = document.getElementsByClassName("collapsible");
	var i;
	for (i = 0; i < coll.length; i++) {
	  coll[i].addEventListener("click", function () {
		this.classList.toggle("active");
		var content = this.nextElementSibling;
		if (content.style.display === "block") {
			content.style.display = "none";
			content.style.maxHeight = null;
		} else {
			content.style.display = "block";
			content.style.maxHeight = content.scrollHeight + "px";
		}
	  });
	}
});

// Function to get day suffix (st, nd, rd, th)
function getDaySuffix(day) {
	if (day >= 11 && day <= 13) {
		return 'th';
	}
	switch (day % 10) {
		case 1: return 'st';
		case 2: return 'nd';
		case 3: return 'rd';
		default: return 'th';
	}
}