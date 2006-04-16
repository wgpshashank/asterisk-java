/*
 *  Copyright 2004-2006 Stefan Reuter
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.asteriskjava.io.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.asteriskjava.io.ServerSocketFacade;
import org.asteriskjava.io.SocketConnectionFacade;


/**
 * Default implementation of the ServerSocketFacade interface using standard
 * java.io classes (ServerSocket in this case).
 * 
 * @author srt
 * @version $Id$
 */
public class ServerSocketFacadeImpl implements ServerSocketFacade
{
    private ServerSocket serverSocket;

    public ServerSocketFacadeImpl(int port, int backlog, InetAddress bindAddress)
            throws IOException
    {
        this.serverSocket = new ServerSocket(port, backlog, bindAddress);
    }

    public SocketConnectionFacade accept() throws IOException
    {
        Socket socket;

        socket = serverSocket.accept();

        return new SocketConnectionFacadeImpl(socket);
    }

    public void close() throws IOException
    {
        serverSocket.close();
    }
}
