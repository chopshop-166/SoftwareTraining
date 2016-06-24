#!/usr/bin/make

CONTENT:=content
OUTDIR:=output
FILES:=$(wildcard ${CONTENT}/*.md)

.PHONY: default slides pdf latex all clean

default: slides

slides: $(FILES:${CONTENT}/%.md=${OUTDIR}/%/index.html)
pdf:    $(FILES:${CONTENT}/%.md=${OUTDIR}/%/presentation.pdf)
latex:  $(FILES:${CONTENT}/%.md=${OUTDIR}/%/presentation.tex)

all: clean slides pdf latex

# Dependencies {{{
# Pandoc supports five different kinds of slide format, so choose flags as appropriate
SLIDES?=slidy

ifeq (${SLIDES},slideous)
  DEPDIR=${OUTDIR}/${SLIDES}
  SLIDEFLAGS=-V slideous-url="../slideous"
  DEPFILE=slideous.zip

${DEPFILE}:
	wget http://goessner.net/download/prj/slideous/slideous.zip

${DEPDIR}: ${DEPFILE}
	mkdir -p $@
	unzip $< -d $@

else ifeq (${SLIDES},dzslides)
  # No flags needed, here for documentation

else ifeq (${SLIDES},revealjs)
  REVEALVER=3.3.0
  DEPFILE=revealjs-${REVEALVER}.tar.gz
  SLIDEFLAGS=-V revealjs-url="../reveal.js-${REVEALVER}"
  DEPDIR=${OUTDIR}/reveal.js-${REVEALVER}

${DEPFILE}:
	wget https://github.com/hakimel/reveal.js/archive/${REVEALVER}.tar.gz -O $@

${DEPDIR} $@/.dirstamp: ${DEPFILE}
	mkdir -p ${OUTDIR}
	tar -xC "${OUTDIR}" -f $<
	touch $@/.dirstamp

else ifeq (${SLIDES},s5)
  # DEPDIR=${OUTDIR}/${SLIDES}
  uidefault=s5-blank/ui/default
  DEPDIR=${OUTDIR}/${uidefault}
  SLIDEFLAGS=-V s5-url="../${uidefault}/${uidefault}"
  DEPFILE=s5.zip

${DEPFILE}:
	wget http://meyerweb.com/eric/tools/s5/s5-blank.zip -O $@

${DEPDIR}: ${DEPFILE}
	mkdir -p $@
	unzip $< '${uidefault}/*' -d $@


else ifeq (${SLIDES},slidy)
  DEPDIR=
  SLIDEFLAGS=
endif

SLIDEFLAGS?=
DEPDIR?=
# }}}

# Generation rules {{{
PANDOC=pandoc $< -o $@ -t ${SLIDES}
SOURCES=${CONTENT}/%.md ${OUTDIR}/%

${OUTDIR}/%/index.html: ${SOURCES} ${DEPDIR}
	${PANDOC} -s ${SLIDEFLAGS} ${FLAGS}

${OUTDIR}/%/presentation.pdf: ${SOURCES}
	${PANDOC} --toc

${OUTDIR}/%/presentation.tex: ${SOURCES}
	${PANDOC}

.PRECIOUS: ${OUTDIR}/%
${OUTDIR}/%: ${CONTENT}/%.md
	if [[ -d '${CONTENT}/$*' ]]; then cp -r "${CONTENT}/$*" "$@"; else mkdir -p $@; fi
# }}}

clean:
	rm -rf ${OUTDIR} &> /dev/null

# vim: fdm=marker
