/*
 *  @(#)Simplex.java  08/10/2010
 *  @charset "UTF-8";
 * 
 *  Copyright (c) 2010 Freddy. All Rights Reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 * 
 *  -Redistribution of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 *  -Redistribution in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 *  Neither the name of Freddy or the names of contributors may
 *  be used to endorse or promote products derived from this software without
 *  specific prior written permission.
 * 
 *  This software is provided "AS IS," without a warranty of any kind. ALL
 *  EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 *  ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 *  OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. Freddy
 *  AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 *  AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 *  DERIVATIVES. IN NO EVENT WILL Freddy OR ITS LICENSORS BE LIABLE FOR ANY LOST
 *  REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 *  INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 *  OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 *  EVEN IF Freddy HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 *  You acknowledge that this software is not designed, licensed or intended
 *  for use in the design, construction, operation or maintenance of any
 *  nuclear facility.
 */

package mx.uacam.fdi.io.simplex.resolvedor;

import mx.uacam.fdi.io.simplex.resolvedor.mate.Ecuacion;

/**
 *
 * @author Freddy
 */
public interface Simplex {
    public double[] maximizar(Ecuacion fo, Ecuacion[] restricciones);
    public double[] minimizar(Ecuacion fo, Ecuacion[] restricciones);
}
