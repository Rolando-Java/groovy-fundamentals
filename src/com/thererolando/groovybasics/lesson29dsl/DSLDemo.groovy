package com.thererolando.groovybasics.lesson29dsl

import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString(includePackage = false, includeNames = true)
class XSSFWorkbook {
    final List<XSSFSheet> xssfSheets = []

    XSSFSheet createSheet(int sheetIndex) {
        XSSFSheet xssfSheet = new XSSFSheet(sheetIndex: sheetIndex)
        this.xssfSheets << xssfSheet
        Sheet.rowIndex = 0
        xssfSheet
    }
}

@ToString(includePackage = false, includeNames = true)
class XSSFSheet {
    Integer sheetIndex
    final List<XSSFRow> xssfRows = []

    XSSFRow createRow(int rowIndex) {
        XSSFRow xssfRow = new XSSFRow(rowIndex: rowIndex)
        this.xssfRows << xssfRow
        Row.cellIndex = 0
        xssfRow
    }
}

@ToString(includePackage = false, includeNames = true)
class XSSFRow {
    Integer rowIndex
    final List<XSSFCell> xssfCells = []

    XSSFCell createCell(int cellIndex, String cellValue) {
        XSSFCell xssfCell = new XSSFCell(cellIndex: cellIndex, cellValue: cellValue)
        xssfCells << xssfCell
        xssfCell
    }
}

@ToString(includePackage = false, includeNames = true)
class XSSFCell {
    Integer cellIndex
    String cellValue
}

/*
 @DelegatesTo permite especificar cuál será el tipo de delegado del cierre
 y la estrategia a implementar por parte del closure. Esta anotación también se puede usar
 para ayudar al verificador de tipos ( TypeChecked) que nos informará errores en caso
 llamemos atributos o métodos que la clase delegada no pueda encontrar.
 Por supuesto, también es compatible con CompileStatic.
 */

class ExcelBuilder {

    static XSSFWorkbook build(@DelegatesTo(value = Workbook.class, strategy = Closure.DELEGATE_ONLY) Closure<Void> closure) {
        XSSFWorkbook wb = new XSSFWorkbook()
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.delegate = new Workbook(wb)
        closure()
        wb
    }

}

class Workbook {
    final XSSFWorkbook wb
    static Integer sheetIndex = 0

    Workbook(XSSFWorkbook wb) {
        this.wb = wb
    }

    void sheet(@DelegatesTo(value = Sheet.class, strategy = Closure.DELEGATE_ONLY) Closure<Void> closure) {
        XSSFSheet sheet = wb.createSheet(sheetIndex)
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.delegate = new Sheet(sheet)
        closure()
        sheetIndex++
    }
}

class Sheet {
    final XSSFSheet sheet
    static Integer rowIndex = 0

    Sheet(XSSFSheet sheet) {
        this.sheet = sheet
    }

    void row(@DelegatesTo(value = Row.class, strategy = Closure.DELEGATE_ONLY) Closure<Void> callable) {
        XSSFRow row = sheet.createRow(rowIndex)
        callable.resolveStrategy = Closure.DELEGATE_ONLY
        callable.delegate = new Row(row)
        callable.call()
        rowIndex++
    }
}

class Row {
    final XSSFRow row
    static Integer cellIndex = 0

    Row(XSSFRow row) {
        this.row = row
    }

    void cell(Object value) {
        XSSFCell cell = row.createCell(cellIndex, (value as String))
        cellIndex++
    }
}

@CompileStatic
class DSLTest {
    XSSFWorkbook getWorkbook() {
        ExcelBuilder.build {
            sheet {
                row {
                    cell 'First value'
                    cell 'Second value'
                }
                row {
                    cell 'Third value'
                    cell 'Fourth value'
                }
            }
            sheet {
                row {
                    cell 'Fifth value'
                }
            }
        }
    }
}

DSLTest dslTest = new DSLTest()
println dslTest.workbook