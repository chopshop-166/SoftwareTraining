#!/usr/bin/make

FILES:=${wildcard *.md}
OUTDIR:=output
# CSS:=http://msoucy.me/theme/css/main.css

.PHONY: default slides pdf latex all clean
.PRECIOUS: $(OUTDIR)/%

default: slides

slides: $(FILES:%.md=$(OUTDIR)/%/index.html)
pdf:    $(FILES:%.md=$(OUTDIR)/%/presentation.pdf)
latex:  $(FILES:%.md=$(OUTDIR)/%/presentation.tex)

all: clean slides pdf latex

PANDOC=pandoc $< -o $@

${OUTDIR}/%/index.html: %.md ${OUTDIR}/%
	#${PANDOC} -t slidy -s --css $(CSS) --self-contained
	#${PANDOC} -t slidy -s --css $(CSS)
	${PANDOC} -t slidy -s

${OUTDIR}/%/presentation.pdf: %.md ${OUTDIR}/%
	${PANDOC} --toc

${OUTDIR}/%/presentation.tex: %.md ${OUTDIR}/%
	${PANDOC}

${OUTDIR}/%: %.md
	mkdir -p $(OUTDIR)/$*

clean:
	rm -rf $(OUTDIR) &> /dev/null

# Images
${OUTDIR}/git-frc/index.html: ${OUTDIR}/git-frc/pull-request.png
${OUTDIR}/git-frc/pull-request.png: pull-request.png ${OUTDIR}/git-frc
	cp $< $@

